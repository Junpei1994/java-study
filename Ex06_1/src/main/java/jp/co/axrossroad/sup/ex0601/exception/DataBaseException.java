package jp.co.axrossroad.sup.ex0601.exception;

/**
 * データベース例外クラス.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public class DataBaseException extends Exception {

    /**
     * エラーメッセージ.
     */
    private String errMsg;

    /**
     * コンストラクタ.
     * @param t 例外オブジェクト(例外チェーン用)
     * @param msg エラーメッセージ
     */
    public DataBaseException(Throwable t, String msg) {
        super(t);
        this.errMsg = msg;
    }

    /**
     * エラーメッセージを取得する.
     * @return エラーメッセージ
     */
    public String getErrMsg() {
        return this.errMsg;
    }
}
