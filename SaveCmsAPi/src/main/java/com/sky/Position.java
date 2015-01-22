package com.sky;


public class Position implements Comparable<Position> {
	
	private int x;
	private int y;
	
	public Position(int i, int j) {
		
		this.x = i;
		this.y = j;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false ;
		if (!(obj instanceof Position))	return false;	
		Position objToCompare = (Position) obj;
		if (this.x==objToCompare.x &&
				this.y == objToCompare.y) return true;
		else 
			return false;
	}
	
	public int compareTo(Position o) {
		
		if(this.equals(o)) return 0;
		if ((this.x < o.x) || (this.x == o.x && this.y < o.y)) return -1;
		else return 1;
	}

}
