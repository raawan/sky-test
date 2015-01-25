package com.sky;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Util {

	public static  DateTimeZone getDefaultTimeZone() {

		return DateTimeZone.getDefault();
	}

	public static  Date createDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, DateTimeZone zone) {

		DateTime dt = new DateTime(year,monthOfYear,dayOfMonth,hourOfDay,minuteOfHour,zone);
		return dt.toDate();
	}
	
	public static  Date createDateWithDefaultTimeZone(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {

		DateTime dt = new DateTime(year,monthOfYear,dayOfMonth,hourOfDay,minuteOfHour,getDefaultTimeZone());
		return dt.toDate();
	}
	
	public static  void addTileToSchedule(ClientSchedule clientSchedule, TileSchedule tileSchedule) {

		clientSchedule.getClientTileSchedules().add(tileSchedule);
	}
	
	public static  TileSchedule createTileSchedule(Tile tile, Date startDate) {
		
		return new TileSchedule(tile,startDate);
	}
	
	public static  Tile createTile(Label tileLabel, Position position) throws InvalidTileException {

		return new Tile(tileLabel,position);
	}
	
	public static  Position createPosition(int xCoordinate, int yCoordinate) {

		return new Position(xCoordinate,yCoordinate);
	}

	public static  Label createLabel(String tileLabel2) {

		return new Label(tileLabel2);
	}
}
