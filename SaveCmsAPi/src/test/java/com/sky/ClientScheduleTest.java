package com.sky;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import static com.sky.Util.*;

public class ClientScheduleTest {
	
	@Test
	public void GIVEN_aListOfClientSchedule_THEN_ClientScheduleShouldBeAddedInChronologicalOrder() {
		
		ClientSchedule clientSchedule = new ClientSchedule();
		
		Tile tile1 = createTile(createLabel("label1"), createPosition(1, 1));
		Date startDate1 = createDate(2015,1,2,13,40,getDefaultTimeZone());
		TileSchedule tileSchedule1 = createTileSchedule(tile1, startDate1);
		
		Tile tile2 = createTile(createLabel("label2"), createPosition(1, 1));
		Date startDate2 = createDate(2015,1,2,13,39,getDefaultTimeZone());
		TileSchedule tileSchedule2 = createTileSchedule(tile2, startDate2);
		
		addTileToSchedule(clientSchedule,tileSchedule1);
		addTileToSchedule(clientSchedule,tileSchedule2);
		
		assertEquals(tileSchedule2,clientSchedule.getClientTileSchedules().first());
		assertEquals(tileSchedule1,clientSchedule.getClientTileSchedules().last());
	}
	
	@Test
	public void GIVEN_aListOfClientSchedule_THEN_ClientScheduleShouldBeAddedInChronologicalOrder_2() {
		
		ClientSchedule clientSchedule = new ClientSchedule();
		
		Tile tile1 = createTile(createLabel("label1"), createPosition(1, 1));
		Date startDate1 = createDate(2015,1,2,13,40,getDefaultTimeZone());
		TileSchedule tileSchedule1 = createTileSchedule(tile1, startDate1);
		
		Tile tile2 = createTile(createLabel("label2"), createPosition(1, 1));
		Date startDate2 = createDate(2013,2,2,13,30,getDefaultTimeZone());
		TileSchedule tileSchedule2 = createTileSchedule(tile2, startDate2);
		
		Tile tile3 = createTile(createLabel("label3"), createPosition(1, 1));
		Date startDate3 = createDate(2015,1,2,14,44,getDefaultTimeZone());
		TileSchedule tileSchedule3 = createTileSchedule(tile3, startDate3);
		
		Tile tile4 = createTile(createLabel("label4"), createPosition(1, 1));
		Date startDate4 = createDate(2015,1,2,13,31,getDefaultTimeZone());
		TileSchedule tileSchedule4 = createTileSchedule(tile4, startDate4);
		
		addTileToSchedule(clientSchedule,tileSchedule1);
		addTileToSchedule(clientSchedule,tileSchedule2);
		addTileToSchedule(clientSchedule,tileSchedule3);
		addTileToSchedule(clientSchedule,tileSchedule4);
		
		assertEquals(tileSchedule2,clientSchedule.getClientTileSchedules().first());
		assertEquals(tileSchedule3,clientSchedule.getClientTileSchedules().last());
		assertEquals(tileSchedule1,clientSchedule.getClientTileSchedules().higher(tileSchedule4));
		
	}
	
	@Test
	public void GIVEN_aListOfClientScheduleOnSameDateWithDifferentPosition_THEN_ClientScheduleShouldBeAddedInOrderOfTheirPositions_1() {
		
		ClientSchedule clientSchedule = new ClientSchedule();
		
		Tile tile1 = createTile(createLabel("label1"), createPosition(1, 1));
		Date startDate1 = createDate(2015,1,2,13,40,getDefaultTimeZone());
		TileSchedule tileSchedule1 = createTileSchedule(tile1, startDate1);
		
		Tile tile2 = createTile(createLabel("label2"), createPosition(1, 2));
		TileSchedule tileSchedule2 = createTileSchedule(tile2, startDate1);
		
		addTileToSchedule(clientSchedule,tileSchedule1);
		addTileToSchedule(clientSchedule,tileSchedule2);
		
		assertEquals(tileSchedule1,clientSchedule.getClientTileSchedules().first());
		assertEquals(tileSchedule2,clientSchedule.getClientTileSchedules().last());
	}
	
	@Test
	public void GIVEN_aListOfClientScheduleOnSameDateWithDifferentPosition_THEN_ClientScheduleShouldBeAddedInOrderOfTheirPositions_2() {
		
		ClientSchedule clientSchedule = new ClientSchedule();
		
		Tile tile1 = createTile(createLabel("label1"), createPosition(2, 1));
		Date startDate1 = createDate(2015,1,2,13,40,getDefaultTimeZone());
		TileSchedule tileSchedule1 = createTileSchedule(tile1, startDate1);
		
		Tile tile2 = createTile(createLabel("label2"), createPosition(1, 3));
		TileSchedule tileSchedule2 = createTileSchedule(tile2, startDate1);
		
		addTileToSchedule(clientSchedule,tileSchedule1);
		addTileToSchedule(clientSchedule,tileSchedule2);
		
		assertEquals(tileSchedule2,clientSchedule.getClientTileSchedules().first());
		assertEquals(tileSchedule1,clientSchedule.getClientTileSchedules().last());
	}
	
	@Test
	public void GIVEN_aListOfClientScheduleOnSameDateWithDifferentPosition_THEN_ClientScheduleShouldBeAddedInOrderOfTheirPositions_3() {
		
		ClientSchedule clientSchedule = new ClientSchedule();
		
		Tile tile1 = createTile(createLabel("label1"), createPosition(2, 1));
		Date startDate1 = createDate(2015,1,2,13,40,getDefaultTimeZone());
		TileSchedule tileSchedule1 = createTileSchedule(tile1, startDate1);
		
		Tile tile2 = createTile(createLabel("label2"), createPosition(2, 3));
		TileSchedule tileSchedule2 = createTileSchedule(tile2, startDate1);
		
		Tile tile3 = createTile(createLabel("label3"), createPosition(1, 3));
		TileSchedule tileSchedule3 = createTileSchedule(tile3, startDate1);
		
		addTileToSchedule(clientSchedule,tileSchedule1);
		addTileToSchedule(clientSchedule,tileSchedule2);
		addTileToSchedule(clientSchedule,tileSchedule3);
		
		assertEquals(tileSchedule3,clientSchedule.getClientTileSchedules().first());
		assertEquals(tileSchedule2,clientSchedule.getClientTileSchedules().last());
	}
	
}
