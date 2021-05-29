package Array;

import java.util.HashMap;

public class FindPairsOfSum {

	public static int getPairSum(int [] a, int k) {
		int count = 0;
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		
		for(int i =0 ; i<a.length; i ++) {
			int x = k-a[i];
			
			if(!m.containsKey(x)) {
				//m.put(a[i];
				
				
			}
		}
		return count ++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
