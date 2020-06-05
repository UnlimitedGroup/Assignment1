package model;

public abstract class Obstacle implements Cloneable {
	private Square currentSquare;
	
	public Obstacle () {
		this.currentSquare = null;
	}
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	public void setCurrentSquare(Square s) {
		this.currentSquare = s;
	}
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
