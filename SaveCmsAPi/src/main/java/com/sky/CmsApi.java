package com.sky;

import java.util.TreeSet;

public class CmsApi {

	public boolean checkTileExistForGivenDateAndPosition(TileSchedule tileSchedule,
			ClientSchedule clientSchedule) {

		if(clientSchedule.getClientTileSchedules().contains(tileSchedule)) 
			return true;
		return false;
	}

	public boolean checkATileExistBeforeGivenNewTileSchedule(
			TileSchedule tileSchedule2, ClientSchedule clientSchedule) {

		TreeSet<TileSchedule> clientTileSchedules = clientSchedule.getClientTileSchedules();
		if (clientTileSchedules.size()==0) return false;
		else {
			clientTileSchedules.add(tileSchedule2);
			if(clientTileSchedules.headSet(tileSchedule2).size()>0) return true;
			return false;
		}
	}

	public boolean checkNoTileExistAfterGivenNewTileSchedule(
			TileSchedule tileSchedule2, ClientSchedule clientSchedule) {

		return true;
	}


}
