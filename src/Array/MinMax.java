
/*Maximum and minimum of an array using minimum number of comparisons
  If n is odd:    3*(n-1)/2  
  If n is even:   1 Initial comparison for initializing min and max, 
                           and 3(n-2)/2 comparisons for rest of the elements  
                      =  1 + 3*(n-2)/2 = 3n/2 -2
*/
package Array;

import SortingAlgorithm.SelectionSort;

class Pair{
	int min;
	int max;
}

public class MinMax { 
	
	public Pair getMinMax(int [] arry , int n) {
		Pair minmax = new Pair();
		int i ;
		if(n%2 == 0) {
			if(arry[0]<arry[1]) {
				minmax.min = arry[0];
				minmax.max = arry[1];
			}else if (arry[0]>arry[1]) {
				minmax.min = arry[1];
				minmax.max = arry[0];
			}
			i = 2;
		}else {
			minmax.min = arry[0];
			minmax.max = arry[0];
			i = 1;
		}
		
		while(i<n-1) {
			if( arry[i] > arry[i+1]) {
				if(arry[i] > minmax.max) {
					minmax.max = arry[i];
				}else if( arry[i + 1] < minmax.min) {
					minmax.min = arry[i+1];
				}
			}else {
				if(arry[i+1] > minmax.max) {
					minmax.max = arry[i+1];
				}else if( arry[i] < minmax.min) {
					minmax.min = arry[i];
				}
				
			}
			i += 2;
		}
		return minmax;
	}

	public static void main(String[] args) {
		
		MinMax minmax = new MinMax();
		Pair pair = new Pair();
		int [] sortedList = {1,2,3,4,5,6,7,8,9,10};
		SelectionSort ss = new SelectionSort();
		pair  = minmax.getMinMax(ss.listToSort(), ss.listToSort().length);
		System.out.println("Max ::" +pair.max);
		System.out.println("Min ::" +pair.min);

	}

}
