package com.sky;

import java.util.TreeSet;

public class ClientSchedule {
	
	private TreeSet<TileSchedule> clientTileSchedules = new TreeSet<TileSchedule>();

	public TreeSet<TileSchedule> getClientTileSchedules() {
		return clientTileSchedules;
	}

	public void setClientTileSchedules(TreeSet<TileSchedule> clientTileSchedules) {
		this.clientTileSchedules = clientTileSchedules;
	}

}
