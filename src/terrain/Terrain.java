package terrain;

import javafx.scene.image.Image;
import units.Unit;

// TODO: You may refer to the Unit classes (Archer, Cavalry, Infantry, Pikeman) for how to setup the Image for the other Terrain classes.
// NOTE: TerrainOutOfBounds is a special case and the code is fully given.
public abstract class Terrain {
	protected int MOVEMENT_COST;
	protected boolean impassable = false;
	protected boolean occupied = false;
	protected Unit occupyingUnit = null;
	
	public Terrain(int movementCost) {
		this.MOVEMENT_COST = movementCost;
		if(this.MOVEMENT_COST < 0 ) {
			this.impassable = true;
		}
	}
	
	public int getMovementCost() {
		return MOVEMENT_COST;
	}
	
	public void occupy(Unit occupyingUnit) {
		this.occupyingUnit = occupyingUnit;
		this.occupied = true;
	}
	
	public void unoccupy() {
		this.occupyingUnit = null;
		this.occupied = false;
	}
	
	public Unit getOccupyingUnit() {
		return this.occupyingUnit;
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
	
	public boolean isBlocked() {
		return (impassable == true || occupied == true)? true:false;
	}
	
	
	public abstract Image getImage() ;
}