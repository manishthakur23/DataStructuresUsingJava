package Array;

public class UnionArray {
	
	public int[] unionArray( int a1 [], int a2 []) {
		int ans = a1.length+a2.length;
		int [] unionArray = new int[ans];
		
		int i = 0, j = 0 , z = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j])
            	unionArray[z++] = a1[i++];
            else if (a2[j] < a1[i])
            	unionArray[z++] = a1[j++];
            else {
            	unionArray[z++] = a1[j++];
                i++;
            }
         
       }
        
        while (i < a1.length )
        	unionArray[z++] = a1[i++];
        while (j < a2.length)
        	unionArray[z++] = a2[j++];
		return unionArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 [] = {1,2,3,4,5,6,7,8,9,10};
		int a2 [] = {2,3,4,5,12,13,14,15,22,23,36,56};
		UnionArray ua = new UnionArray();
		int a3 [] = ua.unionArray(a1, a2);
		
		for(int element : a3) {
			System.out.print(element+",");
		}

	}

}
