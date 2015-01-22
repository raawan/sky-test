package com.sky;

import java.util.Set;
import java.util.TreeSet;

public class ClientSchedule {
	
	private Set<Tile> tiles = new TreeSet<Tile>();

	public Set<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(Set<Tile> tiles) {
		this.tiles = tiles;
	}


}
