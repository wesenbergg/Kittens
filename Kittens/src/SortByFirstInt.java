import java.util.Comparator;

public class SortByFirstInt implements Comparator<int[]> {
	@Override
	public int compare(int[] list1, int[] list2) {
		int diff = list1[0] - list2[0];
		
		return (diff == 0) ? list1[1] - list2[1]: diff;
	}
}
