import java.util.ArrayList;

public class CLdistance {

	private ArrayList<CLpoint2D> tab;
	
	private double distance = 0;
	
	public CLdistance(int n) {
		tab = new ArrayList<CLpoint2D>(n);
	}
	
	public void m_ajouterPoint(CLpoint2D point) {
		tab.add(point);
	}
	
	public void m_ajouterPoint(int x, int y) {
		tab.add(new CLpoint2D(x, y));
	}
	
	public void m_afficherPoints() {
		for (CLpoint2D point : tab) {
			point.m_afficherCoordo();
		}
	}

	public void m_calculDistance() {
		double d = 0.0;
		int x = tab.get(0).getX(), y = tab.get(0).getY();
		
		for (CLpoint2D point : tab) {
			d += Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
			
			x = point.getX();
			y = point.getY();
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
