package model;

import exceptions.squareBoundsException;

//Square
public class Square {
	private int row;
	private int column;
	private boolean selectStatus;
	/**
	 * Create the square object
	 * @param row
	 * @param column
	 * @param selectStatus
	 * @throws squareBoundsException
	 */
	public Square (int row, int column, boolean selectStatus) throws squareBoundsException {
		this.row = row;
		this.column = column;
		this.selectStatus = selectStatus;
	}
	/**
	 * @return the squares row
	 */
	public int getRow() {
		return this.row;
	}
	/**
	 * @return the squares column
	 */
	public int getColumn() {
		return this.column;
	}
	/**
	 * @return whether the square is selected 
	 */
	public boolean getSelectStatus() {
		return this.selectStatus;
	}
	/**
	 * Set the squares select status
	 * @param status
	 */
	public void setSelectStatus(boolean status) {
		this.selectStatus = status;
	}
}

