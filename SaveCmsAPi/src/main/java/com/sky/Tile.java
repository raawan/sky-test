package com.sky;

import java.util.Date;

public class Tile implements Comparable<Tile> {
	
	private String label;
	private Position position;
	private Date scheduleDate;
	
	public Tile(String label, Position position, Date scheduleDate) {
		
		this.label = label;
		this.position = position;
		this.scheduleDate = scheduleDate;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false ;
		if (!(obj instanceof Tile))	return false;	
		Tile objToCompare = (Tile) obj;
		if(this.position.equals(objToCompare.position) 
				&& this.scheduleDate.equals(objToCompare.scheduleDate))
			return true;
		
		return false;
		
	}
	public int compareTo(Tile o) {
		
		if(this.equals(o)) return 0;
		if(this.scheduleDate.before(o.scheduleDate)) return -1;
		else return 1;
	}

}
