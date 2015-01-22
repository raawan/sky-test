package com.sky;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;



public class CmsApiTest {
	
	@Test
	public void GIVEN_inputTilePositionAndTimeCollidesWithSomeOtherExstingTileInSchedule_THEN_returnTrue() {
		
		ClientSchedule schedule = new ClientSchedule();
		Tile tile = new Tile("tileLabel",new Position(2,3), new Date());
		schedule.getTiles().add(tile);
		assertTrue(new CmsApi().checkTileExistForGivenDateAndPosition(tile,schedule));
	}
	
}
