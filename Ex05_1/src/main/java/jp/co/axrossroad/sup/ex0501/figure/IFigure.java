package jp.co.axrossroad.sup.ex0501.figure;

/**
 * 図形情報の取得インターフェース.
 * @author nakagawa.junpei
 *
 */
public interface IFigure {
    /**
     * 図形情報の取得.
     * @return 図形情報(図形名、1辺の長さ等)
     */
    String getFigureInfo();

    /**
     * 図形面積の取得.
     * @return 面積
     */
    double getArea();

    /**
     * 円周の取得.
     * @return 円周の長さ
     */
    double getCircumference();

}
