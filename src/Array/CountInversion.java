package Array;

import java.util.Arrays;

public class CountInversion {
	
	public static int mergeAndCount(int [] a, int l , int m , int r) {
		int swaps = 0 ;
		
		int left [] = Arrays.copyOfRange(a, l, m+1);
		int right [] = Arrays.copyOfRange(a, m+1, r+1);
		
		int i = 0 , j = 0 , k = l ;
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				a[k++]=left[i++];
			}else {
				a[k++] = right[j++];
				swaps += (m+1) - (l+i);
			}
		}
		
		while(i<left.length) {
			a[k++] = left[i++];
		}
		while(j<right.length) {
			a[k++] = right[j++];
		}
		
		return swaps;
	}
	
	public static int countInversion(int [] a, int l , int r) {
		
		int  count = 0;
		
		if(l<r) {
			int m = (l+r)/2;
			
			count += countInversion(a, l, m);
			count += countInversion(a, m+1, r);
			
			count += mergeAndCount(a, l, m, r);
			
			
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 20, 6, 4, 5 };
		 
        System.out.println(
        		countInversion(arr, 0, arr.length - 1));

	}

}
