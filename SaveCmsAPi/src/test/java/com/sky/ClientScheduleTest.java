package com.sky;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Iterator;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

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
		
		Iterator<TileSchedule> itr = clientSchedule.getClientTileSchedules().iterator();
		TileSchedule tmp = null;
		while(itr.hasNext()) {
			tmp = itr.next();
			System.out.println(tmp.getTile().getLabel().getLabel() + ":" +tmp.getStartDate());
		}
	}
	
	private DateTimeZone getDefaultTimeZone() {

		return DateTimeZone.getDefault();
	}

	private Date createDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, DateTimeZone zone) {

		DateTime dt = new DateTime(year,monthOfYear,dayOfMonth,hourOfDay,minuteOfHour,zone);
		return dt.toDate();
	}
	
	private void addTileToSchedule(ClientSchedule clientSchedule, TileSchedule tileSchedule) {

		clientSchedule.getClientTileSchedules().add(tileSchedule);
	}
	
	private TileSchedule createTileSchedule(Tile tile, Date startDate) {
		
		return new TileSchedule(tile,startDate);
	}
	
	private Tile createTile(Label tileLabel, Position position) {

		return new Tile(tileLabel,position);
	}
	
	private Position createPosition(int xCoordinate, int yCoordinate) {

		return new Position(xCoordinate,yCoordinate);
	}

	private Label createLabel(String tileLabel2) {

		return new Label(tileLabel2);
	}
}