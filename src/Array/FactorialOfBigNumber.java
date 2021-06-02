package Array;

public class FactorialOfBigNumber {
	
	public static void factorial(int n) {
		int [] res = new int[500];
		int res_size = 1;
		res[0] = 1;
		
		for(int i = 2 ; i < n ; i++) {
			res_size = multiplier(i, res, res_size);
		}
		
		System.out.print("Factorial of number :: ");
		for(int i = res_size-1 ; i > 0; i--) {
			System.out.print(res[i]);
		}

	
	}
	
	public static int multiplier( int x , int [] res , int res_size) {
		int carry = 0;
		for(int i = 0 ; i < res_size ; i++ ) {
			int prod = x * res[i] + carry;
			res[i] = prod % 10;
			carry = prod / 10;
		}
		
		while (carry != 0) {
			res[res_size] = carry % 10;
			carry =  carry / 10;
			res_size++;
		}
		return res_size;
	}
	
	public static void main(String args[])
    {
        factorial(100);
    }

}
