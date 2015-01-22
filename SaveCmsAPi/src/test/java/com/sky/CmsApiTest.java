package com.sky;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;



public class CmsApiTest {

	private static final String TILE_LABEL_1 = "tileLabel1";
	private static final String TILE_LABEL_2 = "tileLabel21";
	@Test
	public void GIVEN_inputTilePositionAndTimeCollidesWithSomeOtherExstingTileInSchedule_THEN_returnTrue() {

		ClientSchedule clientSchedule = createScheduleTestData();
		Date scheduledDateOfNewTile = new Date();
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,3));
		TileSchedule tileSchedule = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		assertTrue(new CmsApi().checkTileExistForGivenDateAndPosition(tileSchedule,clientSchedule));
	}


	@Test
	public void GIVEN_inputTilePositionAndTimeDoNotCollidesWithSomeOtherExstingTilesInSchedule_THEN_returnFalse() {

		ClientSchedule clientSchedule = createScheduleTestData();
		Date scheduledDateOfNewTile = createDate(2015, 1, 20, 5, 33, DateTimeZone.getDefault());
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,3));
		TileSchedule tileSchedule = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		assertFalse(new CmsApi().checkTileExistForGivenDateAndPosition(tileSchedule,clientSchedule));
	}

	private Date createDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, DateTimeZone zone) {

		DateTime dt = new DateTime(year,monthOfYear,dayOfMonth,hourOfDay,minuteOfHour,zone);
		return dt.toDate();
	}

	private void addTileToSchedule(ClientSchedule clientSchedule, TileSchedule tileSchedule) {

		clientSchedule.getClientTileSchedules().add(tileSchedule);
	}

	private Tile createTile(Label tileLabel, Position position) {

		return new Tile(tileLabel,position);
	}
	
	private TileSchedule createTileSchedule(Tile tile, Date startDate) {
		
		return new TileSchedule(tile,startDate);
	}
	
	private Position createPosition(int xCoordinate, int yCoordinate) {

		return new Position(xCoordinate,yCoordinate);
	}

	private ClientSchedule createScheduleTestData() {

		ClientSchedule schedule = new ClientSchedule();
		Tile tile = createTile(createLabel(TILE_LABEL_1),createPosition(2,3));
		TileSchedule tileSchedule = createTileSchedule(tile,new Date());
		addTileToSchedule(schedule,tileSchedule);
		return schedule;
	}

	private Label createLabel(String tileLabel2) {

		return new Label(tileLabel2);
	}
}
