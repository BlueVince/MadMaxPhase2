
public class CLpoint3D
extends CLpoint2D {

	private int z;
	
	public CLpoint3D() {
		super();
		this.setZ(0);
	}

	public CLpoint3D(int x, int y, int z) {
		super(x, y);
		this.setZ(z);
	}

	public CLpoint3D(CLpoint2D point2D) {
		super(point2D.getX(), point2D.getY());
		this.setZ(0);
	}

	public CLpoint3D(CLpoint2D point2D, int z) {
		super(point2D.getX(), point2D.getY());
		this.setZ(z);
	}
	
	public void m_afficherCoordo() {
		System.out.println("(" + this.getX() + ";" + this.getY() + ";" + this.getZ() + ")");
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
}
