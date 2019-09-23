
public class CLpoint2D {
	
	private int x;
	
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = Math.abs(x);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = Math.abs(y);
	}
	
}
