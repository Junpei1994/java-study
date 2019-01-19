package jp.co.axrossroad.sup.ex0301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *　郵便番号リストを読み込み、htmlファイルに書き出すクラス.
 * @author nakagawa.junpei
 *
 */
public class ZipCodeFilter {
    /**
     * 郵便番号リストを読み込み、htmlファイルに書き出す.
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        BufferedReader buffReader = null;
        PrintWriter pw = null;
        String postCode = "";
        String address = "";
        String strBuff = "";
        String[] splitBuff = null;
        StringBuilder sb;

        //csvファイルの読み込み
        try {
            buffReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("data/13TOKYO.CSV"), "Shift_JIS"));
            File file = new File("out/zipcode.html");
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            pw.println("<html>");
            pw.println("<head><meta charset=\"UTF-8\"></head>");
            pw.println("<body>");

            //見出し
            pw.println("<table border=1>");
            pw.println("<tr>");
            pw.println("<th nowrap>郵便番号</th>");
            pw.println("<th nowrap>住所</th>");
            pw.println("</tr>");

            strBuff = buffReader.readLine();
            while (strBuff != null) {
                strBuff = strBuff.replaceAll("\"", "");
                splitBuff = strBuff.split(",");
                sb = new StringBuilder(splitBuff[2]);
                sb.insert(3, "-");
                postCode = sb.toString();
                splitBuff[8] = splitBuff[8].replaceAll("以下に掲載がない場合", "");
                splitBuff[8] = splitBuff[8].replaceAll("（次のビルを除く）", "");
                address = splitBuff[6] + splitBuff[7] + splitBuff[8];
                strBuff = buffReader.readLine();
                pw.println("<tr align=\"left\">");
                pw.println("<td nowrap>");
                pw.println(postCode);
                pw.println("</td>");
                pw.println("<td nowrap>");
                pw.println(address);
                pw.println("</td>");

                pw.println("</tr>");

            }

            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffReader.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
