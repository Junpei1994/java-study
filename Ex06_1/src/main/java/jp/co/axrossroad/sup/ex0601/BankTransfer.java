package jp.co.axrossroad.sup.ex0601;

import java.util.List;

import jp.co.axrossroad.sup.ex0601.db.dao.AccountDao;
import jp.co.axrossroad.sup.ex0601.db.dao.impl.AccountDaoImpl;
import jp.co.axrossroad.sup.ex0601.db.dto.AccountDto;
import jp.co.axrossroad.sup.ex0601.exception.DataBaseException;
import jp.co.axrossroad.sup.ex0601.util.DataPrinter;

/**
 * 口座振込実行クラス.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public class BankTransfer {

    /**
     * 預金口座情報の出力と振込処理.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        // 預金口座情報テーブルアクセス用クラスのインスタンスを生成
        AccountDao dao;

        // 預金口座情報のリスト
        List<AccountDto> accountList = null;

        try {
            dao = new AccountDaoImpl();

        } catch (DataBaseException e) {
            System.err.println(e.getErrMsg());
            e.printStackTrace();
            // 処理終了
            return;
        }

        /*
         * ------------------------------------------------------------------------
         * 全件の預金口座情報の取得
         * ------------------------------------------------------------------------
         */
        try {
            accountList = dao.selectAll();
        } catch (DataBaseException e) {
            System.err.println(e.getErrMsg());
            e.printStackTrace();
            // 処理終了
            return;
        }

        System.out.println("--- 振込前 ---");
        // 全件の預金口座情報を出力
        DataPrinter.print(accountList);

        // 支店番号:101、口座番号:1234567の預金口座情報
        AccountDto ac1011234567 = null;
        // 支店番号:115、口座番号:7856342の預金口座情報
        AccountDto ac1157856342 = null;

        /*
         * ------------------------------------------------------------------------
         * 預金口座情報テーブルの更新
         * ------------------------------------------------------------------------
         */
        try {
            // 支店番号:101、口座番号:1234567 の預金口座情報の取得
            ac1011234567 = dao.selectByKey("101", "1234567");
            // 支店番号:115、口座番号:7856342 の預金口座情報の取得
            ac1157856342 = dao.selectByKey("115", "7856342");

            // 支店番号:101、口座番号:1234567の預金残高を500円減算
            ac1011234567.setAccountBalance(ac1011234567.getAccountBalance() - 500);
            // 支店番号:115、口座番号:7856342の預金残高を500円加算
            ac1157856342.setAccountBalance(ac1157856342.getAccountBalance() + 500);

            // 支店番号:101、口座番号:1234567の預金残高を更新
            // 支店番号:115、口座番号:7856342の預金残高を更新
            dao.updateBalance(ac1011234567, ac1157856342);

        } catch (DataBaseException e) {
            System.err.println(e.getErrMsg());
            e.printStackTrace();
            // 処理終了
            return;
        }

        /*
         * ------------------------------------------------------------------------
         * 全件の預金口座情報の再取得
         * ------------------------------------------------------------------------
         */
        try {
            // 預金口座情報の全件取得
            accountList = dao.selectAll();
        } catch (DataBaseException e) {
            System.err.println(e.getErrMsg());
            e.printStackTrace();
            // 処理終了
            return;
        }

        // DAO使用終了
        dao.dispose();

        System.out.println("--- 振込後 ---");
        // 全件の預金口座情報を出力
        DataPrinter.print(accountList);
    }
}
