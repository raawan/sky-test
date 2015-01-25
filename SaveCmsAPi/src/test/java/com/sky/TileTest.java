package com.sky;

import org.junit.Test;

public class TileTest {

	
	@Test(expected=InvalidTileException.class)
	public void GIVEN_BlankLabel_THEN_InvalidTileException() throws InvalidTileException {
		
		new Tile(new Label(""),new Position(2,3));
	}
	
	@Test(expected=InvalidTileException.class)
	public void GIVEN_LabelMoreThan30Chars_THEN_InvalidTileException() throws InvalidTileException {
		
		new Tile(new Label("1234567890123456789012345678901"),new Position(2,3));
	}
	
	@Test(expected=InvalidTileException.class)
	public void GIVEN_LabelContainCharactersOtherThanAlphaNumericOrSpace_THEN_InvalidTileException() throws InvalidTileException {
		
		new Tile(new Label("labelWithInvalidchar**"),new Position(2,3));
	}
	
	@Test
	public void GIVEN_LabelContainSpaceAndNoCharsOtherThanAlphaNumeric_THEN_NoInvalidTileException() throws InvalidTileException {
		
		new Tile(new Label("labelWith Spacechar"),new Position(2,3));
	}
}
