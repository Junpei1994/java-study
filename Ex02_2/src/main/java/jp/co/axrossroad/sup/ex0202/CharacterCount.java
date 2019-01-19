package jp.co.axrossroad.sup.ex0202;

/**
 * 文字列の分解と数え上げを行い、疑似的な棒グラフの形で標準出力へ出力するクラス.
 * @author nakagawa.junpei
 *
 */
public class CharacterCount {
    /**
     * 文字列の分解と数え上げを行い、疑似的な棒グラフの形で標準出力へ出力する.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        String sentence = "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language. It is designed to be simple enough that many programmers can achieve fluency in the language. The Java programming language is related to C and C++ but is organized rather differently, with a number of aspects of C and C++ omitted and a few ideas from other languages included. It is intended to be a production language, not a research language, and so, as C. A. R. Hoare suggested in his classic paper on language design, the design has avoided including new and untested features. The Java programming language is strongly and statically typed. This specification clearly distinguishes between the compile-time errors that can and must be detected at compile time, and those that occur at run time. Compile time normally consists of translating programs into a machine-independent byte code representation.";
        int count[] = { 0, 0, 0, 0, 0 };
        String[] strArray = sentence.split("");

        //文字列のカウント
        for (int i = 0; i < strArray.length; i++) {
            switch (strArray[i]) {
            case "a":
                count[0]++;
                break;
            case "b":
                count[1]++;
                break;
            case "c":
                count[2]++;
                break;
            case "d":
                count[3]++;
                break;
            case "e":
                count[4]++;
                break;
            }
        }
        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] / 5;
        }

        //グラフの出力
        String outStr = "";
        for (int i = 20; i >= 1; i--) {
            for (int c = 0; c < count.length; c++) {
                if (i <= count[c]) {
                    outStr += "*";
                } else {
                    outStr += " ";
                }
            }
            System.out.println(outStr);
            outStr = "";
        }
        System.out.println("------");
        System.out.println("abcde");

    }

}
