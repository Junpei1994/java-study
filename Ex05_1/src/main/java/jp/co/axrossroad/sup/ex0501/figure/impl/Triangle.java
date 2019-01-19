package jp.co.axrossroad.sup.ex0501.figure.impl;

import jp.co.axrossroad.sup.ex0501.figure.IFigure;

/**
 * 三角形の情報を保持するクラス.
 * @author nakagawa.junpei
 *
 */
public class Triangle implements IFigure {

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
     * コンストラクタ.
     * ヘロンの公式を使用して、面積を求める.
     * @param sideA 1辺
     * @param sideB 2辺
     * @param sideC 3辺
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.figureInfo = "三角形" + "(辺1: " + sideA + ",辺2: " + sideB + ",辺3: " + sideC + ")";
        double s = ((sideA + sideB + sideC) / 2);
        double calcResult = Math.sqrt(s * ((s - sideA) * ((s - sideB)) * (s - sideC)));

        this.area = calcResult;
        this.cirumfernce = sideA + sideB + sideC;
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
