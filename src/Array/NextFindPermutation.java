package Array;

import java.util.Arrays;

public class NextFindPermutation {
	public static int[] swap(int [] a, int left , int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		
		return a;
	}
	
	public static int[] reverse(int [] a, int left, int right) {
		while(left < right ) {
			int temp = a[left];
			a[left++]=a[right];
			a[right--]= temp;
		}
		return a;
	}
	
	
	
	public static  boolean findNextPermutation( int [] a) {
		if(a.length <= 1) {
			return false;
		}
		
		int last = a.length - 2;
		
		while (last >= 0) { //went wrong
			if(a[last] < a[last+1]) {
				break;
			}
			last --;
		}
		
		if(last < 0) {
			return false;
		}
		
		int nextGreater = a.length-1 ;
		for (int i = a.length - 1  ; i > last ; i--) {//Reminder
			if(a[i]>a[last] ) {
				nextGreater = i;
				break;				
			}
		}
		
		a = swap(a,last, nextGreater);
		
		a = reverse(a, last+1, a.length-1);
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {3, 2, 1};
        if (!findNextPermutation(data))
            System.out.println("There is no higher"
                               + " order permutation "
                               + "for the given data.");
        else {
            System.out.println(Arrays.toString(data));
        }

	}

}
