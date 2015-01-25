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
		
		if(label.getLabel().isEmpty() || label.getLabel().length()>30) {
			throw new InvalidTileException();
		}
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
