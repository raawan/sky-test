package com.sky;

import java.util.Set;
import java.util.TreeSet;

public class ClientSchedule {
	
	private Set<TileSchedule> clientTileSchedules = new TreeSet<TileSchedule>();

	public Set<TileSchedule> getClientTileSchedules() {
		return clientTileSchedules;
	}

	public void setClientTileSchedules(Set<TileSchedule> clientTileSchedules) {
		this.clientTileSchedules = clientTileSchedules;
	}

}
