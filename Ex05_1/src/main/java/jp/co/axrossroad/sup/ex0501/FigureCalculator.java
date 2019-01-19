package jp.co.axrossroad.sup.ex0501;

import jp.co.axrossroad.sup.ex0501.figure.IFigure;
import jp.co.axrossroad.sup.ex0501.figure.impl.Circle;
import jp.co.axrossroad.sup.ex0501.figure.impl.Rectangle;
import jp.co.axrossroad.sup.ex0501.figure.impl.Square;
import jp.co.axrossroad.sup.ex0501.figure.impl.Triangle;

/**
 * 各種図形の面積と周長を表示するクラス.
 * ※このコードに対するレビューは不要です.
 * @author kubo.yusuke
 */
public class FigureCalculator {
    /**
     * 図形に初期値を設定し、その面積と周長を表示する.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        // IFigureインタフェースの配列を準備
        IFigure[] figureArray = new IFigure[4];

        // 正方形：1辺の長さ
        figureArray[2] = new Square(5.0);

        // 長方形：短辺、長辺の長さ(引数で渡す場合は順不同。クラス内部で長辺、短辺を区別して保持)
        figureArray[1] = new Rectangle(10.0, 5.0);

        // 円：半径の長さ
        figureArray[0] = new Circle(10.0);

        // 三角形：3辺の長さ
        figureArray[3] = new Triangle(3.0, 2.0, 4.0);

        // 拡張for文による配列全要素への先頭からの順次アクセス
        for (IFigure f : figureArray) {
            // 図形の名称
            System.out.println(f.getFigureInfo());
            // 面積の表示
            System.out.println(" 面積: " + f.getArea());
            // 周長の表示
            System.out.println(" 周長: " + f.getCircumference());
        }
    }
}
