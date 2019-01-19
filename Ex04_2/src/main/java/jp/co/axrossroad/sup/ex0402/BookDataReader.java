package jp.co.axrossroad.sup.ex0402;

import java.util.Arrays;
import java.util.Comparator;

import jp.co.axrossroad.sup.ex0402.bean.BookBean;

/**
 * 書籍管理csvを読み込み、日付順にソートし標準出力するクラス.
 * @author nakagawa.junpei
 *
 */
public class BookDataReader {

    /**
     * 読み込みファイルのパス.
     */
    private static final String INPUT_FILE_PATH = "data/books.csv";

    /**
     * 書籍管理csvを読み込み、日付を昇順にソートし標準出力する.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        FileAccess fa = new FileAccess(INPUT_FILE_PATH);

        BookBean[] bookArray = fa.read();
        if (bookArray == null) {
            System.out.println("ファイルの読み込みに失敗しました。");
            return;
        }else if(bookArray.length == 0) {
            System.out.println("ファイルの中身がありません。");
            return;
        }

        //寄贈日昇順にソート
        Arrays.sort(bookArray, new Comparator<BookBean>() {
            @Override
            public int compare(BookBean book1, BookBean book2) {
                // 日付比較は、文字列の辞書式比較を使用
                return book1.getDonationDate().compareTo(book2.getDonationDate());
            }
        });

        //寄贈日:書籍名を標準出力に表示
        for (int i = 0; i < bookArray.length; i++) {
            System.out.println(bookArray[i].getDonationDate() + ":" + bookArray[i].getBookName());
        }

    }

}
