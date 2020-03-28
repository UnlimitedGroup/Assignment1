package model;

//Square
public class Square {
	private int row;
	private int column;
	private boolean selectStatus;

	public Square (int row, int column, boolean selectStatus) {
		this.row = row;
		this.column = column;
		this.selectStatus = selectStatus;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	public boolean getSelectStatus() {
		return this.selectStatus;
	}
	public boolean setSelectStatus() {
		/*NEEDS WORK needs so that only one tile can be selected at one time
		 */
		return true;
	}
}
