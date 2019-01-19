# Ex01_1

### 概要
一般的なFizzBuzz問題です。

### 技術要素
* 標準出力
* 算術演算子
* 制御構造
* 変数

### リファレンス
* Schoo
  * Java入門 Javaの概要と歴史
  * Java入門 開発環境 eclipseの操作
  * Java入門 Javaの基本構文

### Git
* 作業ブランチ
  * develop/Ex01_1
* MergeRequestタイトル
  * Ex01_1

---
## 課題
1～100までの整数を順に半角スペース区切りで表示しなさい。ただし、以下の条件に当てはまる場合は、数字の代わりに指定された文字列を表示しなさい。

#### 条件
* 3の倍数の場合→「Fizz」
* の倍数の場合→「Buzz」
* 3と5両方の倍数の場合→「FizzBuzz」

#### 出力例
```
1 2 Fizz 4 Buzz Fizz 7 (途中省略) 13 14 FizzBuzz 16 17 (以下省略)
```

#### ヒント
改行せずに数字(数値文字列)を表示する場合は、`System.out.println(変数);`の代わりに`System.out.print(変数);`を使用します。

#### 作成するクラスのFQCN

* `jp.co.axrossroad.sup.ex0101.FizzBuzz`
  * 「`jp.co.axrossroad.sup.ex0101`」というパッケージを作成して、その中に「`FizzBuzz`」というクラスを作成します
