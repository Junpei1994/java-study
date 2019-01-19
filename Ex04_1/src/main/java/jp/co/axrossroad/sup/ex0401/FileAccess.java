package jp.co.axrossroad.sup.ex0401;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV形式の点数データを読み込むクラス.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public class FileAccess {

    /**
     * 読み込む点数データファイルのパス.
     */
    private String filePath;

    /**
     * コンストラクタ.
     *
     * @param filePath 読み込むファイルのパス
     */
    public FileAccess(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 点数データファイルを読み込み、学生クラスのインスタンスの配列を返す.
     *
     * @return 学生クラスのインスタンスの配列
     */
    public Student[] read() {

        List<Student> studentList = new ArrayList<Student>();

        try (FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = split(line);

                if (tokens == null || tokens.length < 6) {
                    continue;
                }

                Student s = new Student();

                s.setName(tokens[0]);
                s.setScoreJapanese(Integer.parseInt(tokens[1]));
                s.setScoreMathematics(Integer.parseInt(tokens[2]));
                s.setScoreEnglish(Integer.parseInt(tokens[3]));
                s.setScoreScience(Integer.parseInt(tokens[4]));
                s.setScoreSociety(Integer.parseInt(tokens[5]));

                studentList.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (studentList.size() > 0) {
            return (Student[]) studentList.toArray(new Student[0]);
        }

        return null;
    }

    /**
     * 引数の文字列をカンマで分割し、文字列の配列に格納する.
     *
     * @param line 分割対象の文字列
     * @return カンマで分割した後の文字列の配列
     */
    public String[] split(String line) {
        return line.split(",");
    }
}
