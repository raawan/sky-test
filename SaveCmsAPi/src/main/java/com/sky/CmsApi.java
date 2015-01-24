package com.sky;

public class CmsApi {

	public boolean checkTileExistForGivenDateAndPosition(TileSchedule tileSchedule,
			ClientSchedule clientSchedule) {
		
		if(clientSchedule.getClientTileSchedules().contains(tileSchedule)) 
			return true;
		return false;
	}

	public boolean checkATileExistBeforeGivenNewTileSchedule(
			TileSchedule tileSchedule2, ClientSchedule clientSchedule) {

		return false;
	}
	
	
}
