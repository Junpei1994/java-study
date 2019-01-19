package jp.co.axrossroad.sup.ex0201;
/**
 * 配列の走査と閏年判定を行い、結果を標準出力に出力するクラス.
 * @author nakagawa.junpei
 *
 */
public class LeapYearJudgment {
    /**
     * 配列の走査と閏年判定を行い、結果を標準出力に出力する.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        int[] years = { 2014, 2015, 2016, 2100, 2400 };
        for (int i = 0; i < years.length; i++) {
            if (isLeapYear(years[i])) {
                System.out.println(years[i] + "年は閏年です。");
            } else {
                System.out.println(years[i] + "年は閏年ではありません。");
            }
        }
    }
    /**
     * 西暦年が閏年かどうか判定する.
     * @param year 西暦年
     * @return yearが閏年の場合true
     */
    private static boolean isLeapYear(int year) {

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
