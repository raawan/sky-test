package com.sky;

import static org.junit.Assert.assertEquals;

import java.util.Date;

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
