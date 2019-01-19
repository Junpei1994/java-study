package jp.co.axrossroad.sup.ex0402;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axrossroad.sup.ex0402.bean.BookBean;

/**
 * CSV形式の書籍データを読み込むクラス.
 * @author nakagawa.junpei
 *
 */
public class FileAccess {

    /**
     * 読み込む書籍データファイルのパス.
     */
    private String filePath;

    /**
     * コンストラクタ.
     * @param filePath 読み込むファイルパス
     */
    public FileAccess(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 書籍データファイルを読み込み、書籍Beanのインスタンスの配列を返す.
     * @return 書籍Beanのインスタンス配列.
     */
    public BookBean[] read() {
        List<BookBean> BookBeanList = new ArrayList<BookBean>();
        BufferedReader bufferedReader = null;
        File file = new File(filePath);
        if(!file.exists()) {
            return null;
        }
        try {
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;

            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = split(line);

                if (tokens == null || tokens.length < 5) {
                    continue;
                }

                BookBean book = new BookBean();

                book.setIsbn10Code(tokens[0]);
                book.setIsbn13Code(tokens[1]);
                book.setBookName(tokens[2]);
                book.setDonationDay(tokens[3]);
                book.setDonorName(tokens[4]);

                BookBeanList.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (BookBeanList.size() > 0) {
            return (BookBean[]) BookBeanList.toArray(new BookBean[0]);
        }
        BookBean[] emptyBook = new BookBean[0];
        return emptyBook;

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
