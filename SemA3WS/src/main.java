public class main {

	public static void main(String[] args) {
		CLbonjour CLb = new CLbonjour();
		CLaddition CLa = new CLaddition();
		CLpoint2D CLp = new CLpoint2D();
		
		// 2
		
		System.out.println(CLb.m_bonjour());
		
		// 3
		
		int a = 2, b = 5, r = 0;
		
		r = CLa.m_addition(a, b);
		
		System.out.println(r);
		
		// 4
		
		CLp.setX(10);
		CLp.setY(-8);
		
		int x = CLp.getX(), y = CLp.getY();
		
		System.out.println(x + ":" + y);
		
		// 5
		
		

	}

}
