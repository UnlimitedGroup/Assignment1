package model;

import exceptions.squareBoundsException;

//Square
public class Square {
	private int row;
	private int column;
	private boolean selectStatus;
	
	public Square (int column, int row, boolean selectStatus) throws squareBoundsException {
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
}

