package com.sky;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import static com.sky.Util.*;


public class CmsApiTest {

	private static final String TILE_LABEL_1 = "tileLabel1";
	private static final String TILE_LABEL_2 = "tileLabel21";
	
	@Test
	public void GIVEN_inputTilePositionAndTimeCollidesWithSomeOtherExstingTileInSchedule_THEN_returnTrue() {

		ClientSchedule clientSchedule = createScheduleTestData();
		Date scheduledDateOfNewTile = createDateWithDefaultTimeZone(2015, 1, 20, 3, 30);
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,3));
		TileSchedule tileSchedule = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		assertTrue(new CmsApi().checkTileExistForGivenDateAndPosition(tileSchedule,clientSchedule));
	}


	@Test
	public void GIVEN_inputTilePositionAndTimeDoNotCollidesWithSomeOtherExstingTilesInSchedule_THEN_returnFalse() {

		ClientSchedule clientSchedule = createScheduleTestData();
		Date scheduledDateOfNewTile = createDateWithDefaultTimeZone(2015, 1, 20, 5, 33);
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,3));
		TileSchedule tileSchedule2 = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		assertEquals(1,clientSchedule.getClientTileSchedules().size());
		assertFalse(new CmsApi().checkTileExistForGivenDateAndPosition(tileSchedule2,clientSchedule));
	}

	@Test
	public void GIVEN_inputTilePositionAndTimeDoNotCollidesWithSomeOtherExstingTilesInSchedule_THEN_returnFalse_2() {

		ClientSchedule clientSchedule = createScheduleTestData();
		Date scheduledDateOfNewTile = createDateWithDefaultTimeZone(2015, 1, 20, 3, 30);
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,4));
		TileSchedule tileSchedule2 = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		assertEquals(1,clientSchedule.getClientTileSchedules().size());
		assertFalse(new CmsApi().checkTileExistForGivenDateAndPosition(tileSchedule2,clientSchedule));
	}
	
	@Test
	public void GIVEN_aTileExistInClientScheduleBeforeTheGivenNewTileSchedule_THEN_returnTre() {
		
		ClientSchedule clientSchedule = createScheduleTestData();
		
		Date scheduledDateOfNewTile = createDateWithDefaultTimeZone(2015, 1, 20, 3, 32);
		Tile tileToAdd = createTile(createLabel(TILE_LABEL_2),createPosition(2,4));
		TileSchedule tileSchedule2 = createTileSchedule(tileToAdd,scheduledDateOfNewTile);
		
		assertTrue(new CmsApi().checkATileExistBeforeGivenNewTileSchedule(tileSchedule2,clientSchedule));
	}
	
	private ClientSchedule createScheduleTestData() {

		ClientSchedule schedule = new ClientSchedule();
		Tile tile = createTile(createLabel(TILE_LABEL_1),createPosition(2,3));
		TileSchedule tileSchedule = createTileSchedule(tile,createDateWithDefaultTimeZone(2015, 1, 20, 3, 30));
		addTileToSchedule(schedule,tileSchedule);
		return schedule;
	}

}
