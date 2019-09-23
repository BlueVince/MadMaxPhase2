import java.util.ArrayList;

public class CLdistance {

	private ArrayList<CLpoint2D> tab;
	
	public CLdistance() {
		
		tab = new ArrayList();
		
	}
	
	public void m_ajouterPoint(int x, int y) {
		tab.add(new CLpoint2D(x, y));
	}
	
	public void m_affichezPoint() {
		for (CLpoint2D point : tab) {
			point.m_afficherCoordo();
		}
	}
	
}
