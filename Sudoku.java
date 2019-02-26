/* Reference: GeekstoGeeks.com (for logic)*/
public class Sudoku {
	public char[][] sudokugrid;
	public int gridsize;
	public char[] symbolsArr;

	public Sudoku(char[][] matrix, int size, char[] symbolsArr) {
		// TODO Auto-generated constructor stub
		this.gridsize = size;
		this.sudokugrid = new char[size][size];
		this.symbolsArr = symbolsArr;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.sudokugrid[i][j] = matrix[i][j];
			}
		}
	}
	public boolean sudokusolution() {

		// TODO Auto-generated method stub
		for (int i = 0; i < gridsize; i++) {
			for (int j = 0; j < gridsize; j++) {
				if (sudokugrid[i][j] == '0') {
					for (int k = 0; k <=symbolsArr.length; k++) {
						boolean presentinrow = inRow(i, symbolsArr[k], gridsize);
						boolean presentincolumn = inColumn(j, symbolsArr[k], gridsize);
						boolean presentinsmallgrid = inSmallgrid(i, j, symbolsArr[k]);
						if (presentinrow == false && presentincolumn == false && presentinsmallgrid == false) {
							sudokugrid[i][j] = symbolsArr[k];
							if (sudokusolution()) {
								return true;
							} else {
								sudokugrid[i][j] = '0';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean inSmallgrid(int row, int column, char symbol) {
		// TODO Auto-generated method stub
		int sgrow = row - (row % 3);
		int sgcolumn = column - (column % 3);
		for (int i = sgrow; i < sgrow; i++) {
			for (int j = sgcolumn; j < sgcolumn; j++) {
				if (sudokugrid[sgrow][sgcolumn] == symbol) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean inColumn(int column, char symbol, int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (sudokugrid[i][column] == symbol) {
				return true;
			}
		}
		return false;
	}

	private boolean inRow(int row, char symbol, int size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (sudokugrid[row][i] == symbol) {
				return true;
			}
		}
		return false;
	}

	public void display() {
		// TODO Auto-generated method stub
		for (int i = 0; i < gridsize; i++) {
			for (int j = 0; j < gridsize; j++) {
				System.out.print(" " + sudokugrid[i][j]);
			}

			System.out.println();
		}
		System.out.println();
	};

}
