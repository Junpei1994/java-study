package jp.co.axrossroad.sup.ex0401;

/**
 * Studentの情報保持クラス.
 * @author nakagawa.junpei
 *
 */
public class Student {

    /**
     * 学生名.
     */
    private String mName;

    /**
     * 国語の点数.
     */
    private int mJpnScore;

    /**
     * 数学の点数.
     */
    private int mMathScore;

    /**
     * 英語の点数.
     */
    private int mEngScore;

    /*
     * 理科の点数.
     */
    private int mSciScore;

    /**
     * 社会の点数.
     */
    private int mSocScore;

    /**
     * 名前を設定する.
     * @param name 名前
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * 名前を取得する.
     * @return 名前
     */
    public String getName() {
        return mName;
    }

    /**
     * 国語の点数を設定する.
     * @param score 点数
     */
    public void setScoreJapanese(int score) {
        mJpnScore = score;
    }

    /**
     * 国語の点数を取得する.
     * @return 点数
     */
    public int getScoreJapanese() {
        return mJpnScore;
    }

    /**
     * 数学の点数を設定する.
     * @param score 点数
     */
    public void setScoreMathematics(int score) {
        mMathScore = score;
    }

    /**
     * 数学の点数を取得する.
     * @return 点数
     */
    public int getScoreMathematics() {
        return mMathScore;
    }

    /**
     * 英語の点数を設定する.
     * @param score 点数
     */
    public void setScoreEnglish(int score) {
        mEngScore = score;
    }

    /**
     * 英語の点数を取得する.
     * @return 点数
     */
    public int getScoreEnglish() {
        return mEngScore;
    }

    /**
     * 理科の点数を設定する.
     * @param score 点数
     */
    public void setScoreScience(int score) {
        mSciScore = score;
    }

    /**
     * 理科の点数を取得する.
     * @return 点数
     */
    public int getScoreScience() {
        return mSciScore;
    }

    /**
     * 社会の点数を設定する.
     * @param score 点数
     */
    public void setScoreSociety(int score) {
        mSocScore = score;
    }

    /**
     * 社会の点数を取得する.
     * @return 点数
     */
    public int getScoreSociety() {
        return mSocScore;
    }

}
