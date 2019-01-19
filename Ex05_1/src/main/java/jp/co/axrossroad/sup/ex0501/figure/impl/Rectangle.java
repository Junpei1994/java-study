package jp.co.axrossroad.sup.ex0501.figure.impl;

import jp.co.axrossroad.sup.ex0501.figure.IFigure;

/**
 * 長方形の情報を保持するクラス.
 * @author nakagawa.junpei
 *
 */
public class Rectangle implements IFigure {

    /**
     * 図形の情報
     */
    String figureInfo;

    /**
     * 面積
     */
    double area;

    /**
     * 円周
     */
    double cirumfernce;

    /**
     * 短辺
     */
    double shortSide;

    /**
     * 長辺
     */
    double largeSide;

    /**
     * コンストラクタ.
     * @param sideA 1辺
     * @param sideB 2辺
     */
    public Rectangle(double sideA, double sideB) {
        if (sideA > sideB) {
            this.largeSide = sideA;
            this.shortSide = sideB;
        } else {
            this.largeSide = sideB;
            this.shortSide = sideA;
        }
        this.figureInfo = "長方形" + "(長辺:" + largeSide + ", 短辺:" + shortSide + ")";
        this.area = sideA * sideB;
        this.cirumfernce = (sideA + sideB) * 2;

    }

    /**
     * 図形情報の取得.
     */
    @Override
    public String getFigureInfo() {
        return this.figureInfo;
    }

    /**
     * 面積の取得.
     */
    @Override
    public double getArea() {
        return this.area;
    }

    /**
     * 円周の長さの取得.
     */
    @Override
    public double getCircumference() {
        return this.cirumfernce;
    }
}
