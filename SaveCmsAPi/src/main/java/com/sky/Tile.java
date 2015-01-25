package com.sky;


public class Tile  {
	
	private Label label;
	private Position position;
	
	public Tile(Label label, Position position) throws InvalidTileException {
		
		validateLabel(label);
		this.label = label;
		this.position = position;
	}

	private void validateLabel(Label label) throws InvalidTileException {
		
		if(isLabelEmpty(label) || 
				isLengthOfLabelGreaterThan30(label) || 
					isLabelContainOnlyAlphaNumericCharsAndSpaces(label)) {
			throw new InvalidTileException();
		}
	}

	private boolean isLabelContainOnlyAlphaNumericCharsAndSpaces(Label label) {
		
		String pattern= "^[a-zA-Z0-9\\s]*$";
		return !label.getLabel().matches(pattern);
	}

	private boolean isLengthOfLabelGreaterThan30(Label label) {
		
		return label.getLabel().length()>30;
	}

	private boolean isLabelEmpty(Label label) {
		return label.getLabel().isEmpty();
	}

	public Position getPosition() {
		
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public boolean equals(Object obj) {
	
		if (obj == null) return false ;
		if (this == obj) return true;
		if (!(obj instanceof Tile))	return false;	
		Tile objToCompare = (Tile) obj;
		if(this.position.equals(objToCompare.position)) 
			return true;
		return false;
	}
	
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
