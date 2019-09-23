import java.util.ArrayList;

public class CLdistance3D {

	private ArrayList<CLpoint3D> tab;
	
	private double distance = 0;
	
	public CLdistance3D(int n) {
		tab = new ArrayList<CLpoint3D>(n);
	}
	
	public void m_ajouterPoint(CLpoint3D point) {
		tab.add(point);
	}
	
	public void m_ajouterPoint(int x, int y, int z) {
		tab.add(new CLpoint3D(x, y, z));
	}
	
	public void m_afficherPoints() {
		for (CLpoint3D point : tab) {
			point.m_afficherCoordo();
		}
	}

	public void m_calculDistance() {
		double d = 0.0;
		int x = tab.get(0).getX(), y = tab.get(0).getY(), z = tab.get(0).getZ();
		
		for (CLpoint3D point : tab) {
			d += Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2) + Math.pow(point.getZ() - z, 2));
			
			x = point.getX();
			y = point.getY();
			z = point.getZ();
		}
		
		this.setDistance(d);
	}

	public double getDistance() {
		return this.distance;
	}

	private void setDistance(double distance) {
		this.distance = distance;
	}

}
