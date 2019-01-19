package jp.co.axrossroad.sup.ex0102;

/**
 * 九九を表で表示するクラス.
 * @author nakagawa.junpei
 *
 */
public class MultiplicationTable {
    /**
    * 九九を表で表示する.
    * @param args コマンドライン引数
    */
    public static void main(String[] args) {

        System.out.print(" |\t");
        int i = 1;
        while(i!=9) {
            System.out.print(i + "\t");
            i++;
        }
        System.out.print(i);
        System.out.println("\n-+--------------------------------------");

        int x = 1;
        int y = 1;

        while (x <= 9) {
            System.out.print(x + "|\t");    
            while (y != 9) {
                System.out.print(y * x + "\t");
                y++;
            }
            System.out.print(y * x);
            System.out.print("\n");
            x++;
            y = 1;
        }

    }

}
