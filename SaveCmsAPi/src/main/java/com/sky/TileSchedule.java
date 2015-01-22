package com.sky;
import java.util.Date;

public class TileSchedule implements Comparable<TileSchedule>{
	
	private Tile tile;
	private Date startDate;
	
	public TileSchedule(Tile tile, Date startDate) {
		this.tile = tile;
		this.startDate = startDate;
	}
	
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) return false ;
		if (this == obj) return true;
		if (!(obj instanceof TileSchedule))	return false;	
		TileSchedule objToCompare = (TileSchedule) obj;
		if(this.getTile().getPosition().equals(objToCompare.getTile().getPosition())
				&& this.getStartDate().equals(objToCompare.getStartDate()))
			return true;
		return false;
	}
	
	public int compareTo(TileSchedule obj) {
		
		if(this.equals(obj)) return 0;
		if(this.getStartDate().before(obj.getStartDate())) return -1;
		if(this.getStartDate().equals(obj.getStartDate())) {
			if(this.getTile().getPosition().compareTo(obj.getTile().getPosition())==-1) return -1;
			else return 1;
		}
		return 1;
	}
	
}
