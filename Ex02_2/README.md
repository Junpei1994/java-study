# Ex02_2

### 概要
文字列の分解と数え上げを行い、疑似的な棒グラフの形で標準出力へ出力します。

### 技術要素
* 二次元配列
* 文字列操作

### リファレンス
* Schoo - Java入門 -計算機プログラムを作りながら学ぶJavaの基本-
  * Java入門 -クラスの書き方-
  * Java入門 -メソッドの書き方-
  * Java入門 -Javaの変数-
  * Java入門 -Javaの配列-
  * Java入門 -Javaの繰り返し処理-
  * Java入門 -Javaの分岐処理-

### Git
* 作業ブランチ
  * develop/Ex02_2
* MergeRequestタイトル
  * Ex02_2

---
## 課題
以下の文字列変数「sentence」の中に、アルファベット小文字のa～eがそれぞれ何個含まれているかを数え、棒グラフ状に表示しなさい。

```java
// プログラム中にコピペして使用してください
String sentence = "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language. It is designed to be simple enough that many programmers can achieve fluency in the language. The Java programming language is related to C and C++ but is organized rather differently, with a number of aspects of C and C++ omitted and a few ideas from other languages included. It is intended to be a production language, not a research language, and so, as C. A. R. Hoare suggested in his classic paper on language design, the design has avoided including new and untested features. The Java programming language is strongly and statically typed. This specification clearly distinguishes between the compile-time errors that can and must be detected at compile time, and those that occur at run time. Compile time normally consists of translating programs into a machine-independent byte code representation.";
```

#### 出力結果
```





*
*
*
*
*
*
*
*
*
*
*
*
*
*
**
-----
abcde
```

棒グラフはアスタリスク「\*」を積み上げて表現します。
「\*」1個が、数えた文字の個数5個分に相当し、5個未満の個数は切り捨てます(含まれている文字数が17個なら、「\*」が3個)。
棒グラフの最大目盛りは文字個数100(=「*」20個)です。

出力結果の上の部分が空いているのは、最大目盛り(20)まで達していない部分です(半角スペースが出力されています)。

* aは77個含まれるので、77 / 5 = 15...2 で、\*が15個
* bは9個含まれるので、9 / 5 = 1...4 で、\*が1個

#### ヒント1
a～eが含まれる個数を数える処理と、棒グラフを出力する処理は別の処理(≒別個の繰り返し処理)になります。
数えながら同時に出力はできません。たぶん。

文字列の中から特定の文字の個数を数える方法はいろいろありますので、
ネットで調べてOKです。

#### ヒント2
文字列を1文字ずつばらして配列に格納する方法は以下のようなやり方があります。「文字」と「文字列」は異なることを意識してください。

`char[] a = 文字列変数.toCharArray();`
とすると、char型配列には、文字列を分解した1文字ずつが各要素に入ります。
なお、文字の比較はequalsでなく、普通に==で比較できます。
##### 例
```java
char[] charArray = str.toCharArray();

if (a[0] == 'b') {
    // char型配列charArrayの0番目の要素が文字'b'と等しい場合の処理
}
```

もしくは、`String[] a = 文字列変数.split("");`
とすると、String型配列には、文字列を分解した1文字分の文字列が各要素に入ります。
なお、文字列の比較はequalsを使用します。

##### 例
```java
String[] strArray = str.split("");

if ("c".equals(strArray[0])) {
    // String型配列strArrayの0番目の要素が文字列"c"と等しい場合の処理
}
```

#### 作成するクラスのFQCN

* `jp.co.axrossroad.sup.ex0202.CharacterCount`
