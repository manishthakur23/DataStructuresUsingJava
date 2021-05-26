package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeArray {
	static int arr1[] = new int[] {1,2,3 };
    static int arr2[] = new int[] { 4,13,19};
	
	public static void mergeSortedArrays(int m, int n) {
		
		int i = 0;
		int j = 0;
		int k = m-1;
		
		while(i<=k && j <n) {
			if(arr1[i]<arr2[j]) {
				i++;
			}else {
				int temp = arr1[k];
				arr1[k] = arr2[j];
				arr2[j] = temp;
				j++;
				k--;
				
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
	}
	
	public static void main(String[] args)
    {
		mergeSortedArrays(arr1.length, arr2.length);
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }

}
