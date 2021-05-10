package Array;

public class FindDuplicate {
	//issue if ) is encountered
	public void findDuplicate(int arry [] , int n) {
		for (int i = 0 ; i < n ; i++) {
			int j = Math.abs(arry[i]);
			if(arry[j]>=0) {
				arry[j] = -arry[j];
			}else {
				System.out.print(j+",");
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 4, 3, 2, 1, 1, 2, 3, 1 };
        int arr_size = arr.length;
        FindDuplicate fd = new FindDuplicate();
        
        fd.findDuplicate(arr, arr_size);
        
       
	}

}
