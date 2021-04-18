import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles all logic of calculating
 * maximum amount of kittens visiting the bed
 * service.
 * @author Boriss
 *
 */
public class Order {
	private static Scanner lukija = new Scanner(System.in);
	
	private static int MAX_KITTENS = 100000;
	private static int MIN_BEDS = 1;
	
	private int potentialKittens;
	private int numberOfBeds;
	private int currentBeds;
	private ArrayList<int[]> timeList;
	private int kittensInBed;
	
	public Order(int potentialKittens, int numberOfBeds) {
		super();
		this.potentialKittens = potentialKittens;
		this.numberOfBeds = numberOfBeds;
		this.timeList = new ArrayList<>();
		this.currentBeds = 0;
		this.kittensInBed = 0;
	}
	
	/**
	 * This function handles inputs of
	 * arrive and departure time. The amount
	 * of asked lines depends of potential visiting 
	 * kittens. Both arrive and departure time are
	 * added to same ArrayList.
	 */
	public void runOrder() {
		for (int i = 0; i < potentialKittens; i++) {
			String[] line = lukija.nextLine().split(" ");
			int[] arriveTime = { Integer.parseInt(line[0]), 0 };
			int[] leaveTime = { Integer.parseInt(line[1]), 1 };
			timeList.add(arriveTime);
			timeList.add(leaveTime);
		}
	}
	
	/**
	 * This function sorts all registered times.
	 * Bed is reserved if there is room (also
	 * the return count is incremented). From
	 * every departure, reserved bed count
	 * decreases. The count of reserved beds
	 * can't increase over actual number of beds
	 * or can't decrease below zero.
	 * @return {Integer} Returns maximum amount of
	 * possible visiting kittens.
	 */
	public int getMaxKittens() {
		kittensInBed = 0;
		timeList.stream().sorted(new SortByFirstInt()).forEach(is -> {
			if(is[1] == 0 && numberOfBeds > currentBeds) {
				currentBeds++;
				kittensInBed++;
			}
			if(is[1] == 1 && currentBeds > 0) {
				currentBeds--;
			}
		});
		return kittensInBed;
	}
	
	public static final class OrderBuilder {
		/**
		 * Builder function for order, encapsulates all
		 * "constructor logic" of the Order.
		 * @return Order
		 */
		public static Order build() {
			String[] line = lukija.nextLine().split(" ");
			int potentialKittens = Integer.parseInt(line[0]);
			int numberOfBeds = Integer.parseInt(line[1]);
	        if(numberOfBeds <= MIN_BEDS || potentialKittens >= MAX_KITTENS)
	        	throw new IllegalArgumentException("n and k (1≤k<n≤100000)");

	        if(numberOfBeds > potentialKittens)
	        	throw new IllegalArgumentException("Not enough kittens yet. (k<n)");
	        
	        return new Order(potentialKittens, numberOfBeds);
	    }
	}
}
