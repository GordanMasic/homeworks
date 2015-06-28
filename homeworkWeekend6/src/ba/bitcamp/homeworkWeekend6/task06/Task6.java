package ba.bitcamp.homeworkWeekend6.task06;

public class Task6 {

	/**
	 * Filling matrix
	 * 
	 * @param matrix
	 */
	public static void fillArray(int[][] matrix) {

		fillArray(matrix, 0, 0, 0);

	}

	/**
	 * Filling matrix
	 * 
	 * @param matrix
	 * @param i
	 *            number of row
	 * @param j
	 *            number of column
	 * @param num
	 *            number to put in matrix
	 */
	public static void fillArray(int[][] matrix, int i, int j, int num) {
		if (i == matrix.length) {
			return;
		}
		if (i < matrix.length) {
			if (j == matrix[i].length) {
				return;
			}
			if (j < matrix[i].length) {
				matrix[i][j] = num;
				j++;
				num++;
				fillArray(matrix, i, j, num);

			}

		}
		num += matrix[0].length - 1;
		j = 0;
		i++;
		fillArray(matrix, i, j, num);
		return;

	}

	public static void main(String[] args) {

		// Making matrix
		int[][] matrix = new int[3][5];

		// Calling recursive method
		fillArray(matrix);

		// printing matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
