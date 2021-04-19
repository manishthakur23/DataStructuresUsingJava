
//Write a program to cyclically rotate an array by one.

package Array;

public class CyclicallyRotate {
	public void cyclicallyRotate(int [] arry) {
		int element = arry[arry.length-1];
		
		for(int i = arry.length-1 ; i > 0; i--) {
			arry[i] = arry[i-1];
		}
		arry[0] = element;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1 [] = {6,2,3,4,5,6,7,8,9,10};
		CyclicallyRotate cr = new CyclicallyRotate();
		cr.cyclicallyRotate(a1);
		
		for(int element : a1) {
			System.out.print(element+",");
		}

	}

}
