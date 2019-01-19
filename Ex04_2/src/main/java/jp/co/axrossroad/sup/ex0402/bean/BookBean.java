package jp.co.axrossroad.sup.ex0402.bean;

/**
 * 書籍のBean.
 * @author nakagawa.junpei
 *
 */
public class BookBean {

    /**
     * ISBN10コード.
     */
    private String isbn10Code;

    /**
     * ISBN13コード.
     */
    private String isbn13Code;

    /**
     * 書籍名.
     */
    private String title;

    /**
     * 寄贈日.
     */
    private String donationDay;

    /**
     * 寄贈者名.
     */
    private String donorName;

    /**
     * ISBN10コードを設定する.
     * @param isbnCode ISBN10コード
     */
    public void setIsbn10Code(String isbnCode) {
        isbn10Code = isbnCode;
    }

    /**
     * ISBN10コードを取得する.
     * @return ISBN10コード
     */
    public String getIsbn10Code() {
        return isbn10Code;
    }

    /**
     * ISBN13コードを設定する.
     * @param isbnCode ISBN13コード
     */
    public void setIsbn13Code(String isbnCode) {
        isbn13Code = isbnCode;
    }

    /**
     * ISBN13コードを取得する.
     * @return ISBN13コード
     */
    public String getIsbn13Code() {
        return isbn13Code;
    }

    /**
     * 書籍名を設定する.
     * @param bookName 書籍名
     */
    public void setBookName(String bookName) {
        title = bookName;

    }

    /**
     * 書籍名を取得する.
     * @return 書籍名
     */
    public String getBookName() {
        return title;
    }

    /**
     * 寄贈日を設定する.
     * @param day 寄贈日
     */
    public void setDonationDay(String day) {
        donationDay = day;
    }

    /**
     * 寄贈日を取得する.
     * @return 寄贈日
     */
    public String getDonationDate() {
        return donationDay;
    }

    /**
     * 寄贈者名を設定する.
     * @param name 寄贈者名
     */
    public void setDonorName(String name) {
        donorName = name;
    }

    /**
     * 寄贈者名を取得する.
     * @return 寄贈者名
     */
    public String getDonorName() {
        return donorName;
    }

}
