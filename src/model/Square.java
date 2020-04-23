package model;

import exceptions.squareBoundsException;

//Square
public class Square {
	private int row;
	private int column;
	private boolean selectStatus;
	private final int maxRow = 6;
	private final int maxCol = 4;
	

	public Square (int row, int column, boolean selectStatus) throws squareBoundsException {
		if (rowColPremodifier (row, column)) {
			this.row = row;
			this.column = column;
		}
		else {
			throw new squareBoundsException();
		}
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
	public void setSelectStatus(boolean status) {
		this.selectStatus = status;
	}
	public boolean rowColPremodifier(int row, int col) {
		if (row >= 0 && row <= maxRow) {
			return true;
		}
		if (col >= 0 && col <= maxCol) {
			return true;
		}
		return false;
	}
}

