package jp.co.axrossroad.sup.ex0601.db.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axrossroad.sup.ex0601.db.dao.AccountDao;
import jp.co.axrossroad.sup.ex0601.db.dto.AccountDto;
import jp.co.axrossroad.sup.ex0601.exception.DataBaseException;

/**
 * 口座アカウントDBへのデータアクセスを行うクラス.
 * @author nakagawa.junpei
 *
 */
public class AccountDaoImpl implements AccountDao {

    /**
     * JDBCドライバ名
     */
    private static final String JDBC_DRIVER_NAME = "org.postgresql.Driver";

    /**
     * 接続URL
     */
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/sup";

    /**
     * ユーザーiD
     */
    private static final String DB_USER = "sup";

    /**
     * パスワード
     */
    private static final String DB_PASSWORD = "sup";

    /**
     * 全件取得SQL
     */
    private static final String SQL_SELECT_ALL = "SELECT * FROM TBL_ACCOUNT ORDER BY BRANCH_NO , ACCOUNT_NO;";

    /**
     * 支店番号と口座番号をキーに預金口座情報を取得
     */
    private static final String SQL_SELECT_BY_KEY = "SELECT * FROM TBL_ACCOUNT WHERE BRANCH_NO = ? AND ACCOUNT_NO = ?;";

    /**
     * 口座番号をキーに預金残高を更新する
     */
    private static final String SQL_UPDATE_BALANCE = "UPDATE TBL_ACCOUNT SET ACCOUNT_BALANCE = ? WHERE ACCOUNT_NO = ? AND BRANCH_NO = ?;";

    /**
     * DBとの接続
     */
    private Connection con = null;

    /**
     * コンストラクタ.
     * DBへの接続を行う.
     * @throws DataBaseException データベース操作失敗時にスロー
     */
    public AccountDaoImpl() throws DataBaseException {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            DataBaseException de = new DataBaseException(e, "データベース接続に失敗しました");
            throw de;

        }

    }

    /**
     * 預金口座情報を全件取得し、預金口座DTOのリストを返す.
     * 預金口座情報一覧は、第1ソートキーが支店番号の昇順、第2ソートキーが口座番号の昇順でソートする
     * @return 預金口座DTOのリスト
     * @throws DataBaseException データベース操作失敗時にスロー
     */
    @Override
    public List<AccountDto> selectAll() throws DataBaseException {
        List<AccountDto> dtoList = new ArrayList<AccountDto>();
        AccountDto dto = null;
        try {
            PreparedStatement pstmt = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dto = new AccountDto();
                dto.setBranchNo(rs.getString("branch_no"));
                dto.setAccountNo(rs.getString("account_no"));
                dto.setAccountName(rs.getString("account_name"));
                dto.setAccountBalance(rs.getLong("account_balance"));
                dtoList.add(dto);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            rollback();
            close();
            e.printStackTrace();
            DataBaseException de = new DataBaseException(e, "データの全件取得に失敗しました");
            throw de;
        }
        return dtoList;
    }

    /**
     * 支店番号と口座番号をキーに預金口座情報を取得し、預金口座DTOを返す.
     * @param branchNo 支店番号
     * @param accountNo 口座番号
     * @return 預金口座DTO
     * @throws DataBaseException データベース操作失敗時にスロー
     */
    @Override
    public AccountDto selectByKey(String branchNo, String accountNo) throws DataBaseException {
        AccountDto dto = null;
        try {
            PreparedStatement pstmt = con.prepareStatement(SQL_SELECT_BY_KEY);
            pstmt.setString(1, branchNo);
            pstmt.setString(2, accountNo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dto = new AccountDto();
                dto.setBranchNo(rs.getString("branch_no"));
                dto.setAccountNo(rs.getString("account_no"));
                dto.setAccountName(rs.getString("account_name"));
                dto.setAccountBalance(rs.getLong("account_balance"));
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            rollback();
            close();
            e.printStackTrace();
            DataBaseException de = new DataBaseException(e, "指定データの取得に失敗しました");
            throw de;
        }
        return dto;
    }

    /**
     * 預金口座情報Beanの情報で、預金残高を更新する.
     * 2レコード分の個別更新は、同一トランザクションの中で実行すること.
     * @param sourceAccount 振込元預金口座DTO
     * @param destinationAccount 振込先預金口座DTO
     *
     * @throws DataBaseException データベース更新失敗時にスロー
     */
    @Override
    public void updateBalance(AccountDto sourceAccount, AccountDto destinationAccount) throws DataBaseException {
        try {

            PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_BALANCE);
            pstmt.setLong(1, sourceAccount.getAccountBalance());
            pstmt.setString(2, sourceAccount.getAccountNo());
            pstmt.setString(3,sourceAccount.getBranchNo());
            pstmt.executeUpdate();
            pstmt.setLong(1, destinationAccount.getAccountBalance());
            pstmt.setString(2, destinationAccount.getAccountNo());
            pstmt.setString(3,destinationAccount.getBranchNo());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            rollback();
            close();
            e.printStackTrace();
            DataBaseException de = new DataBaseException(e, "データの更新に失敗しました");
            throw de;
        }

    }

    /**
     * DAOのデータベースコネクション破棄を行う.
     */
    @Override
    public void dispose() {
        close();

    }

    /*
     * データベースのコネクションクローズを行う.
     */
    private void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * エラー時ロールバックを行う.
     */
    private void rollback() {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
