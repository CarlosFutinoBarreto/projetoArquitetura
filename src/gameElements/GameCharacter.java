package gameElements;

import observer.Observer;

public class GameCharacter {

	public static final int RIGHT= 0;
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	
	private int xCoordinate;
	
	private int yCoordinate;
	
	private int limits;
	
	private Quiver quiver;
	
	public GameCharacter(int limits) {
		super();
		this.limits = limits;
		this.xCoordinate=limits/2;
		this.yCoordinate=limits/2;
		this.quiver = new Quiver();
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void walk(int direction) {
		switch (direction) {
		case GameCharacter.RIGHT:if (this.xCoordinate<this.limits-1) this.xCoordinate++;break;
		case GameCharacter.LEFT:if (this.xCoordinate>0) this.xCoordinate--;break;
		case GameCharacter.UP:if (this.yCoordinate>0) this.yCoordinate--;break;
		case GameCharacter.DOWN:if (this.yCoordinate<this.limits-1) this.yCoordinate++;break;
		}
	}
	
	public Arrow shoot() {
		return this.quiver.getArrow(xCoordinate, yCoordinate, limits);
	}

	public void aquireArrow(Arrow arrow) {
		this.quiver.aquireArrow(arrow);
	}

	public void attach(Observer o) {
		quiver.attach(o);
	}

	public void dettach(Observer o) {
		quiver.dettach(o);
	}
	
	
}
