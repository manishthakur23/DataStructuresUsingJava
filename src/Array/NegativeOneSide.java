//Move all negative numbers to beginning and positive to end with constant extra space
package Array;

public class NegativeOneSide {
	
	public void negativeOneSide( int [] a, int n) {
		int low = 0;
		int high = n-1;
		while (low <= high) {
			if(a[low] < 0 && a[high] < 0) {
				low++;
				
			}else if(a[low] > 0 && a[high] < 0){
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				 low ++;
				 high --;
			}else if( a[low] > 0 && a[high] > 0){
				high --;
			}else {
				low++;
				high--;
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] a = {-1,-2,3,4,5,6,7,8,9,0,-2,-4,-5,79};
        NegativeOneSide ns = new NegativeOneSide();
        ns.negativeOneSide(a, a.length);
        
        for(int i = 0 ; i < a.length ; i++) {
        	if(i == a.length-1) {
        		System.out.print(a[i]);
        	}else {
        		System.out.print(a[i]+",");
        	}
			
		}
	}

}
