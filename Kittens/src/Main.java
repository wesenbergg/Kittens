/**
 * @author Boriss
 */
public class Main {

	/**
	 *	Tehtävänanto:
	 *  n and k (1≤k<n≤100000), the number of potential visiting kittens and the number of beds
	 *  Then follow n lines, each containing two integers xi and yi, meaning that kitten i wants to arrive at time xi and leave at time yi.
	 *  0≤xi<yi≤1000000000
	 */
	
	/**
	 * Testisyöte
5 2
1 4
5 9
3 8
2 7
6 10
	 */
	
	public static void main(String[] args) {
		Order order = Order.OrderBuilder.build();
		order.runOrder();
		System.out.println(order.getMaxKittens());
	}
}
