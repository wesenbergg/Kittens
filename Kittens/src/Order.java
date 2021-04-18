import java.util.ArrayList;
import java.util.Scanner;


public class Order {
	private static Scanner lukija = new Scanner(System.in);
	
	public static int MAX_KITTENS = 100000;
	public static int MIN_BEDS = 1;
	
	private int potentialKittens;
	private int numberOfBeds;
	private int currentBeds;
	private ArrayList<int[]> timeList;
	
	public Order(int potentialKittens, int numberOfBeds) {
		super();
		this.potentialKittens = potentialKittens;
		this.numberOfBeds = numberOfBeds;
		this.timeList = new ArrayList<>();
		this.currentBeds = 0;
	}
	
	public void runOrder() {
		for (int i = 0; i < potentialKittens; i++) {
			String[] line = lukija.nextLine().split(" ");
			int[] arriveTime = { Integer.parseInt(line[0]), 0 };
			int[] leaveTime = { Integer.parseInt(line[1]), 1 };
			timeList.add(arriveTime);
			timeList.add(leaveTime);
		}
		/*timeList.stream().sorted(new SortByFirstInt()).forEach(m -> {
			for (int i : m) System.out.print(i);
			System.out.println("");
		});*/
	}

	int kittensInBed = 0;
	public int getMaxKittens() {
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
