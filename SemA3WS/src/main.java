public class main {

	public static void main(String[] args) {
		
		// 2
		
		CLbonjour CLb = new CLbonjour();
		
		System.out.println(CLb.m_bonjour());
		
		// 3

		CLaddition CLa = new CLaddition();
		
		int a = 2, b = 5, r = 0;
		
		r = CLa.m_addition(a, b);
		
		System.out.println(r);
		
		// 5
		
		CLpoint2D CLp = new CLpoint2D(10, 18);
		
		CLp.m_afficherCoordo();
		
	}

}
