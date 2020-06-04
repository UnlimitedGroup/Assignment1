package model;

public abstract class Obstacle implements Cloneable {
	private Square currentSquare;
	
	/**
	 * Build the obstacle object
	 */
	public Obstacle () {
		this.currentSquare = null;
	}
	/**
	 * @return current square of obstacle
	 */
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	/**
	 * Set current square of obstacle
	 * @param s
	 */
	public void setCurrentSquare(Square s) {
		this.currentSquare = s;
	}
	/**
	 * Clone the obstacle
	 */
	public Obstacle clone() { 
        Object clone = null; 
        try { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  { 
            e.printStackTrace(); 
        } 
        return (Obstacle) clone; 
    } 
} 
