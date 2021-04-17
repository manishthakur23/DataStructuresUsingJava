package SearchAlgorithm;

public class BinearySearch {
	
	public int binearySearch( int [] sortedList , int number) {
		int min = 0;
		int max = sortedList.length - 1;
		while(min <= max) {
			int mid = min + (max-min)/2;
			if(sortedList[mid] == number) {
				return mid;
			}
			
			if(sortedList[mid] < number) {
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] sortedList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		BinearySearch bs = new BinearySearch();
		int number = 0;
		int index = bs.binearySearch(sortedList, number);
		if( index == -1) {
			System.out.println("Number is not present");
		}else {
			System.out.println("Number is present at :"+index+" index");
		}
			
	}

}
