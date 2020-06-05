package model;

import com.google.java.contract.*;

import exceptions.squareBoundsException;

@Invariant({
	"row <= 7 && row >= 0",
	"column <= 5 && column >= 0"})
public class Square {
	private int row;
	private int column;
	private boolean selectStatus;
	
	public Square (int row, int column, boolean selectStatus) throws squareBoundsException {
		this.row = row;
		this.column = column;
		this.selectStatus = selectStatus;
	}
	@Ensures("row <= 7 && row >= 0")
	public int getRow() {
		return this.row;
	}
	@Ensures("column <= 5 && column >= 0")
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

