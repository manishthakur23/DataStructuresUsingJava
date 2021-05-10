package Array;

import java.util.Arrays;

public class MinimizeMaximumDistance {
	
	public int minimizeMaximumDistance(int arry[], int k, int n) {
		if(n==1) {
			return 0;
		}
		
		Arrays.sort(arry);
		int ans = arry[n-1] -arry[0];
		int small = arry[0] + k;
		int big = arry[n-1] - k;
		
		
		
		if(big < small) {
			int temp =  big ;
			big = small ;
			small = temp;
		}
		
		for (int i=1;i<n-1;i++) {
			int add = arry[i]-k;
			int substract = arry[i]-k;
			
			if(add<=big || substract>=small) {
				continue;
			}
			
			if(add-small >= big-substract) {
				small = substract;
			}else {
				big = add;
			}
		}
		
		return Math.min(ans, big-small);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimizeMaximumDistance mn = new MinimizeMaximumDistance();
		int arr[] = {1, 5, 15, 10	};
        int n = arr.length;
        int k = 3;
        System.out.println("Maximum difference is "+mn.minimizeMaximumDistance(arr, k, n));

	}

}
