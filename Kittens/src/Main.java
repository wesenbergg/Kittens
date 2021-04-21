/**
 * @author Boriss
 */
public class Main {

	/**
	 *	Tehtävänanto:
	 *  Syöte: n and k (1≤k<n≤100000), the number of potential visiting kittens and the number of beds
	 *  Then follow n lines, each containing two integers xi and yi, meaning that kitten i wants to arrive at time xi and leave at time yi.
	 *  0≤xi<yi≤1000000000
	 *  
	 *  Halutaan saada selville mikä on maksimi määrä kissoja joille voidaan tarjota sänkyjä. Yksi sänky voi ottaa vastaan yhden kissan,
	 *  ja yksi sänky on varattuna kissalle koko vierailun ajaksi. Kissan vierailun jälkeen voidaan sänkyyn ottaa uusi kissa.
	 *  Esimerkiksi jos kissa1 arvot ovat 1 3 ja kissa2 arvot ovat 3 5, niin voivat nämä kissat jakaa saman sängyn.
	 *  Esimerkiksi jos kissa1 arvot ovat 1 3 ja kissa2 arvot ovat 2 4, niin nämä kissat eivät voi jakaa samaa sänkyä.
	 *  
	 *  Ohjelma siis tulostaa vain maksimi määrän kissoja mitä voi ottaa vastaan.
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
