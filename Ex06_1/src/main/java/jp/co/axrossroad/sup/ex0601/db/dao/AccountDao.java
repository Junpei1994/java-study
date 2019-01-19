package jp.co.axrossroad.sup.ex0601.db.dao;

import java.util.List;

import jp.co.axrossroad.sup.ex0601.db.dto.AccountDto;
import jp.co.axrossroad.sup.ex0601.exception.DataBaseException;

/**
 * 預金口座情報DAOのインタフェース.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public interface AccountDao {

    /**
     * 預金口座情報を全件取得し、預金口座DTOのリストを返す.
     * 預金口座情報一覧は、第1ソートキーが支店番号の昇順、第2ソートキーが口座番号の昇順でソートする
     * @return 預金口座DTOのリスト
     * @throws DataBaseException データベース操作失敗時にスロー
     */
    List<AccountDto> selectAll() throws DataBaseException;

    /**
     * 支店番号と口座番号をキーに預金口座情報を取得し、預金口座DTOを返す.
     * @param branchNo 支店番号
     * @param accountNo 口座番号
     * @return 預金口座DTO
     * @throws DataBaseException データベース操作失敗時にスロー
     */
    AccountDto selectByKey(String branchNo, String accountNo) throws DataBaseException;

    /**
     * 預金口座情報Beanの情報で、預金残高を更新する.
     * 2レコード分の個別更新は、同一トランザクションの中で実行すること.
     * @param sourceAccount 振込元預金口座DTO
     * @param destinationAccount 振込先預金口座DTO
     *
     * @throws DataBaseException データベース更新失敗時にスロー
     */
    void updateBalance(AccountDto sourceAccount, AccountDto destinationAccount) throws DataBaseException;

    /**
     * DAOのデータベースコネクション破棄を行う.
     */
    void dispose();
}
