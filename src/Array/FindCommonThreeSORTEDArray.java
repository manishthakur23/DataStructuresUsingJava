package Array;

import java.util.List;

public class FindCommonThreeSORTEDArray {
	
	public static void findCommonElements( int [] a1, int [] a2, int [] a3) {
		int max = Integer.MIN_VALUE;
		
		int res1 = 1;
		for(int i = 1 ; i < a1.length; i++) {
			max = Math.max(a1[i], max);
			if(a1[i] != a1[res1 - 1]) {
				a1[res1]= a1[i];
			}
			res1++;
		}
		
		int res2 = 1;
		for(int i = 1 ; i < a2.length; i++) {
			max = Math.max(a2[i], max);
			if(a2[i] != a2[res2 - 1]) {
				a2[res2]= a2[i];
			}
			res2++;
		}
		
		int res3 = 1;
		for(int i = 1 ; i < a3.length; i++) {
			max = Math.max(a3[i], max);
			if(a3[i] != a3[res3 - 1]) {
				a3[res3]= a3[i];
			}
			res3++;
		}
		
		int [] freq = new int[max + 1];
		
		for(int i = 0; i < a1.length ; i++) {
			freq[a1[i]]++;
		}
		
		for(int i = 0; i < a2.length ; i++) {
			freq[a2[i]]++;
		}
		
		for(int i = 0; i < a3.length ; i++) {
			freq[a3[i]]++;
		}
		
		System.out.print("Common Elements are :: ");
		for(int i = 0 ; i < freq.length ; i++) {
			if(freq[i] == 3) {
				System.out.print(i+",");
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = { 1, 5, 10, 20, 40, 80 };
        int arr2[] = { 6, 7, 20, 80, 100 };
        int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
        
        findCommonElements(arr1,arr2,arr3);

	}

}
