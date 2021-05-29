package Array;

import java.util.HashMap;

public class FindPairsOfSum {

	public static int getPairSum(int [] a, int k) {
		int twice_count = 0;
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i = 0 ; i<a.length; i++) {
			if(!m.containsKey(a[i])) {
				m.put(a[i], 0);
			}
			m.put(a[i], m.get(a[i])+1);
		}
		
		for(int i = 0 ; i < a.length ; i++) {
			if(m.get(k - a[i]) != null) {
				twice_count += m.get(k-a[i]);
			}
			
			if(k-a[i] == a[i]) {
				twice_count--;
			}
		}
			
		
		return twice_count/2 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
        System.out.println(
            "Count of pairs is "
            + getPairSum(arr, sum));

	}

}
