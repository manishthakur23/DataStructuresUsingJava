// Java program to find intersection of
// two sorted arrays
  

package Array;

public class IntersectionArray {
	
	public int[] intersectionArray( int a1 [], int a2 []) {
		int intersectedArray [] =  new int[a1.length];
		int i = 0;
		int j = 0;
		int z = 0;
		while(i<a1.length && j<a2.length) {
			if(a1[i] > a2[j]) {
				j++;
			}else if (a1[i] < a2[j]){
				i++;
			}else {
				intersectedArray[z++] = a1[i++];
//				z++;
//				i++;
				j++;
			}
		}
		 return intersectedArray;
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 [] = {1,2,3,4,5,6,7,8,9,10};
		int a2 [] = {2,3,4,5,12,13,14,15,22,23,36,56};
		IntersectionArray ia = new IntersectionArray();
		int a3 [] = ia.intersectionArray(a1, a2);
		
		for(int element : a3) {
			System.out.print(element+",");
		}

	}

}
