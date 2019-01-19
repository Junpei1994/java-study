package jp.co.axrossroad.sup.ex0101;

/**
 * FizzBuzzを出力するクラス.
 * @author nakagawa.junpei
 *
 */
public class FizzBuzz {
    /**
     * FizzBuzzを出力する.
     * @param args　コマンドライン引数
     */
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

}
