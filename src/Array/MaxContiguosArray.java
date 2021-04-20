//To print the subarray with the maximum sum, we maintain indices whenever we get the maximum sum.  

package Array;

public class MaxContiguosArray {
	public void maxArray( int [] arry) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending = 0, start = 0, end = 0, s = 0;
		
		for(int i =0 ; i<arry.length ; i++) {
			max_ending +=arry[i];
			
			if(max_so_far < max_ending) {
				max_so_far = max_ending;
				start = s;
				end = i;
			}
			
			if(max_ending < 0) {
				max_ending = 0;
				s = i+1;
			}
		}
		
		System.out.println( " Maximum contigous array :: "+max_so_far);
		System.out.println("start point ::"+start);
		System.out.println("end point ::"+end);
	}

	public static void main(String[] args) {
		int [] a = {-1,2,3,-4,-5,3,6,-10};
		MaxContiguosArray max = new MaxContiguosArray();
		max.maxArray(a);
		

	}

}
