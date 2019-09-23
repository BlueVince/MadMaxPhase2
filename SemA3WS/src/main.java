public class main {

	public static void main(String[] args) {
		
		// 2
		
		CLbonjour CLb = new CLbonjour();
		
		//System.out.println(CLb.m_bonjour());
		
		// 3

		CLaddition CLa = new CLaddition();
		
		int a = 2, b = 5, r = 0;
		
		r = CLa.m_addition(a, b);
		
		//System.out.println(r);
		
		// 5
		
		CLpoint2D point1 = new CLpoint2D(), point2 = new CLpoint2D(-1, 1);
		
		/*
		point1.m_afficherCoordo();
		point2.m_afficherCoordo();
		/**/
		
		// 6
		
		CLdistance dist = new CLdistance(2);
		
		dist.m_ajouterPoint(point1);
		dist.m_ajouterPoint(point2);
		
		dist.m_afficherPoints();
		
		dist.m_calculDistance();
		
		System.out.println(dist.getDistance());
		
		// 7
		
		CLdistance3D dist3D = new CLdistance3D(2);
		
		CLpoint3D point3D1 = new CLpoint3D(point1), point3D2 = new CLpoint3D(4, 5, 9);
		
		dist3D.m_ajouterPoint(point3D1);
		dist3D.m_ajouterPoint(point3D2);
		
		dist3D.m_afficherPoints();
		
		dist3D.m_calculDistance();

		System.out.println(dist3D.getDistance());
		
	}

}
