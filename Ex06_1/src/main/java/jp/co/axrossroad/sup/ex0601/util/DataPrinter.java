package jp.co.axrossroad.sup.ex0601.util;

import java.util.List;

import jp.co.axrossroad.sup.ex0601.db.dto.AccountDto;

/**
 * 口座情報を出力するクラス.
 */
public class DataPrinter {

    /** 口座名義のフォーマット用固定文字列長. */
    private static final int FORMAT_SIZE = 12;

    /**
     * 口座情報の一覧を標準出力に出力する.
     * @param accountList 口座情報のリスト
     */
    public static void print(List<AccountDto> accountList) {
        // TODO 要実装
    }

    /**
     * 口座名義の文字列を固定長にフォーマットする.
     * @param accountName 口座名義
     * @return FORMAT_SIZEまで後ろ半角スペース埋めの口座名義文字列
     */
    private static String formatAccountName(String accountName) {

        if (accountName == null) {
            return "";
        }

        char[] chars = accountName.toCharArray();

        int halfSizeCount = 0;

        for (char c : chars) {
            if ((c <= '\u007e') || // 英数字
                    (c == '\u00a5') || // \記号
                    (c == '\u203e') || // ~記号
                    (c >= '\uff61' && c <= '\uff9f') // 半角カナ
            ) {
                halfSizeCount++;
            } else {
                halfSizeCount += 2;
            }
        }

        int addBlankCount = FORMAT_SIZE - halfSizeCount;

        if (addBlankCount > 0) {
            for (int i = 0; i < addBlankCount; i++) {
                accountName = accountName + " ";
            }
        }

        return accountName;
    }
}
