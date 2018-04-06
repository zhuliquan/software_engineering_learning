package data;

public class Coordinate {
	private int x;
	private int y;
	public static Coordinate DPosition[] = {
			new Coordinate(-1,0),
			new Coordinate(0,-1),
			new Coordinate(0, 1),
			new Coordinate(1, 0),
	};
	public static Coordinate add(Coordinate a,Coordinate b) {
		return new Coordinate(a.getX()+b.getX(), a.getY()+b.getY());
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Coordinate(int x,int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
