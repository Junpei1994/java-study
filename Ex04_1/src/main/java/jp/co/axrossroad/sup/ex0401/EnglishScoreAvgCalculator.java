package jp.co.axrossroad.sup.ex0401;

/**
 * 点数データファイルの先頭から5件分の学生の英語の点数の平均点を表示するクラス.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public class EnglishScoreAvgCalculator {

    /**
     * 読み込みファイルのパス.
     */
    private static final String INPUT_FILE_PATH = "data/score.txt";

    /**
     * 英語の平均点を計算、表示する.
     * @param args コマンドライン引数(使用しない)
     */
    public static void main(String[] args) {

        TsvFileAccess tfa = new TsvFileAccess(INPUT_FILE_PATH);

        // readメソッドの引数で先頭からの件数を指定する
        Student[] studentArray = tfa.read(5);

        if (studentArray == null) {
            System.out.println("ファイルの読み込みに失敗しました。");
            return;
        }

        int engScoreSum = 0;

        for (Student student : studentArray) {
            engScoreSum += student.getScoreEnglish();
        }

        float engScoreAvg = (float) engScoreSum / studentArray.length;

        System.out.println("英語の平均点: " + engScoreAvg);
    }
}
