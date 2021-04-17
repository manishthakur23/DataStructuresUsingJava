/*Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
*/
package Array;

public class Sort012WithoutAlgo {
	
	public void sortWithAlgo(int a[], int n) {
		int low = 0;
		int mid = 0;
		int high = n-1;
		
		while(mid<= high) {
			switch (a[mid]) {
			case 0:
				int temp = a[mid];
				a[mid] = a[low];
				a[low] = temp;
				low ++;
				mid ++;				
				break;
			
			case 1:
				mid++;
				break;
				
			case 2:
				int temp1 = a[mid];
				a[mid] = a[high];
				a[high] = temp1;
				high--;			
				break;		
				

			default:
				throw new IllegalArgumentException("Unexpected value: " + a[mid]);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arry [] = {1,2,0,0,2,1,1,2,0,1,0,0,0,0,2,1,2,1,2,1,2};
		Sort012WithoutAlgo sort = new Sort012WithoutAlgo();
		sort.sortWithAlgo(arry, arry.length);
		
		for(int element : arry) {
			System.out.print(element+",");
		}

	}

}
