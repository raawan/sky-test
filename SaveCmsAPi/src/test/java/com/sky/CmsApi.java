package com.sky;

public class CmsApi {

	public boolean checkTileExistForGivenDateAndPosition(Tile tile,
			ClientSchedule schedule) {
		
		if(schedule.getTiles().contains(tile)) return true;
		return false;
	}

}
