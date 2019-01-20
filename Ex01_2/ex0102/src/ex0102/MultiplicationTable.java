package ex0102;

public class MultiplicationTable {

	public static void main(String[] args) {
		//初期化
		int[] colNumber = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] rowNumber = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int scoreNumber;
		//罫線上の数字
		for (int col = 0; col <= colNumber.length; col++) {
			if (col == 0) {
				System.out.print(" |" + "\t" + colNumber[col] + "\t");
				continue;
			} else if (col == 8) {
				System.out.println(colNumber[col] + "\t");
				break;
			}
			System.out.print(colNumber[col] + "\t");
		}
		//罫線
		String colLine = "-+−-------------------------------------------−−−−−−−−−−−−−−−−−−−−−−−−−−−−−";
		System.out.println(colLine);
		
		//合計値
		for (int row = 0; row <= rowNumber.length; row++) {
			
			for (int col = 0; col <= colNumber.length; col++) {
				scoreNumber = colNumber[col] * rowNumber[row];
				if (col == 0) {
					System.out.print(rowNumber[row] + "|"+ "\t" + scoreNumber + "\t");
					continue;
				} else if (col == 8) {
					System.out.println(scoreNumber);
					break;
				}
				System.out.print(scoreNumber + "\t");
			}
		}

	}

}
