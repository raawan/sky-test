package com.sky;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;



public class CmsApiTest {
	
	@Test
	public void GIVEN_inputTilePositionAndTimeCollidesWithSomeOtherExstingTileInSchedule_THEN_returnTrue() {
		
		ClientSchedule schedule = new ClientSchedule();
		Tile tile = new Tile("tileLabel",new Position(2,3), new Date());
		schedule.getTiles().add(tile);
		assertTrue(new CmsApi().checkTileExistForGivenDateAndPosition(tile,schedule));
	}
	
	@Test
	public void GIVEN_inputTilePositionAndTimeDoNotCollidesWithSomeOtherExstingTilesInSchedule_THEN_returnFalse() {
		
		ClientSchedule schedule = new ClientSchedule();
		Tile tile = new Tile("tileLabel",new Position(2,3), new Date());
		schedule.getTiles().add(tile);
		Date scheduledDateOfNewTile = createDate(2015, 1, 20, 5, 33, DateTimeZone.getDefault());
		Tile tileToAdd = new Tile("tileLabel",new Position(2,3), scheduledDateOfNewTile);
		assertFalse(new CmsApi().checkTileExistForGivenDateAndPosition(tileToAdd,schedule));
	}
	
	private Date createDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, DateTimeZone zone) {
		
		 DateTime dt = new DateTime(year,monthOfYear,dayOfMonth,hourOfDay,minuteOfHour,zone);
		 return dt.toDate();
	}
}
