package jp.co.axrossroad.sup.ex0501.figure.impl;

import jp.co.axrossroad.sup.ex0501.figure.IFigure;

/**
 * 正方形の情報を保持するクラス.
 * @author nakagawa.junpei
 *
 */
public class Square implements IFigure {

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
     * 一辺の長さ
     */
    double length;

    /**
     * コンストラクタ.
     * @param length 1辺の長さ
     */
    public Square(double length) {

        this.figureInfo = "正方形" + "(1辺:" + length + ")";
        this.length = length;
        this.area = length * length;
        this.cirumfernce = length * 4;

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
