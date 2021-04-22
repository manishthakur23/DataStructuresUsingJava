package Array;

public class MaxJumpsToEnd {
	
	public int  MaxJumpsToEnd (int [] a) {
		
		System.out.println("check 1");
		int i = a[0];
		int jumps = 0;
		System.out.println("check 2 :: i ::"+i);
		while(i!=a[a.length-1]) {
			System.out.println("check 3 :: i ::"+i);
			System.out.println("check 3 :: jump ::"+jumps);
			if(a[i] == 0 || a[i] < 0) {
				return -1;
			}
			
			if(i<a.length) {
				i = a[i];
			}
			
			jumps++;		
			
		}
		return jumps;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		MaxJumpsToEnd maxjumps = new MaxJumpsToEnd();
		int jumps = maxjumps.MaxJumpsToEnd(arr);
		System.out.println("Maximum Jumps ::"+jumps);
		

	}

}
