
public class CLpoint2D {
	
	private int x;
	
	private int y;
	
	public CLpoint2D() {
		this.coordo(0, 0);
	}

	public CLpoint2D(int x, int y) {
		this.coordo(x, y);
	}

	private void coordo(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void m_afficherCoordo() {
		System.out.println("(" + this.getX() + ";" + this.getY() + ")");
	}
	
	

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
