package jp.co.axrossroad.sup.ex0501.figure.impl;

import jp.co.axrossroad.sup.ex0501.figure.IFigure;

/**
 * 円の情報を保持するクラス.
 * @author nakagawa.junpei
 *
 */
public class Circle implements IFigure {

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
     * 半径
     */
    double radius;

    /**
     * コンストラクタ.
     * @param radius 半径の長さ
     */
    public Circle(double radius) {
        this.figureInfo = "円" + "(半径:" + radius + ")";
        this.radius = radius;
        this.area = (radius * radius) * Math.PI;
        this.cirumfernce = (radius * 2) * Math.PI;

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
