package Array;

public class NegativePositiveArray {
	
	public static void swap( int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void arrangeNegativePositive( int arr []) throws Exception {
		if(arr.length == 0) {
			throw new Exception("Array is empty");
		}
		
		int i = 0, j = arr.length - 1;
		
		while(i<=j) {
			if(arr[i] < 0 && arr[j] > 0) {
				swap(arr, i, j);
				i++;
				j--;
			}else if(arr[i] > 0 && arr[j] < 0) {
				i++;
				j--;
			}else if(arr[i] > 0) {
				i++;
			}else if(arr[j] < 0) {
				j--;
			}
		}
		
		if( i == 0 || i == arr.length ) {
			for (int z : arr) {
				System.out.print(z+",");				
			}
		}else{
			int k = 0;
			while(i < arr.length && k < arr.length) {
				swap(arr, i, k);
				i++;
				k=k+2;
			}
			for (int z : arr) {
				System.out.print(z+",");				
			}
			
		}		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//int[] arr ={ -5, -2, 5, 2, 4, 7, 1, 8, 10, -8 };
		int[] arr ={ -5, -2, -5, -2, -4, -7, -1, -8, -10, -8 };
		arrangeNegativePositive(arr);

	}

}
