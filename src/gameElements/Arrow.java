package gameElements;

public class Arrow{

	private int xCoordinate;
	
	private int yCoordinate;
	
	private int limits;
	
	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public Arrow(int limits) {
		super();
		this.limits = limits;
	}
	
	public void pickup(int x, int y) {
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	
	public boolean fly() {
		if (this.xCoordinate<this.limits-1) {
			this.xCoordinate++;
			return true;
		}else {
			return false;
		}
		
		
	}

}
