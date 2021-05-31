package Array;

import java.util.HashSet;

public class SumOfSubarrayToZero {
	
	public static boolean findSubArrayIsZero(int [] arr) {
		int sum  = 0;
		HashSet<Integer> hset = new HashSet<Integer>();
		for( int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
			if(arr[i] == 0 ||
					sum == 0 ||
					hset.contains(sum)) {
				return true;
			}
			hset.add(sum);
		}		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 4, 2, -3, 1, 6};
	        if (findSubArrayIsZero(arr))
	            System.out.println(
	                "Found a subarray with 0 sum");
	        else
	            System.out.println("No Such Sub Array Exists!");

	}

}
