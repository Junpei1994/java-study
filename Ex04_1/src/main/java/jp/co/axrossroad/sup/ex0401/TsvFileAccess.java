package jp.co.axrossroad.sup.ex0401;

/**
 * Tsv形式の点数データを読み込むクラス.
 * @author nakagawa.junpei
 *
 */
public class TsvFileAccess extends FileAccess {

    /**
     * コンストラクタ.
     * @param filePath 読み込むファイルパス
     */
    public TsvFileAccess(String filePath) {
        super(filePath);
    }

    /**
     * 点数データファイルを読み込み、学生クラスのインスタンスの配列を引数で指定された行数分返す.
     * @param row 行数
     * @return 学生クラスのインスタンスの配列
     */
    public Student[] read(int row) {
        Student[] studentBuff = super.read();
        if (studentBuff.length <= row) {
            return studentBuff;
        } else {
            Student[] stuList = new Student[row];
            for (int i = 0; i < row; i++) {
                stuList[i] = studentBuff[i];
            }
            return stuList;
        }
    }

    /**
     * 引数の文字列をタブで分割し、文字列の配列に格納する.
     *
     * @param line 分割対象の文字列
     * @return で分割した後の文字列の配列
     */
    @Override
    public String[] split(String line) {
        return line.split("\t");
    }

}
