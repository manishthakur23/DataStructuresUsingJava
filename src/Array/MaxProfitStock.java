package Array;

public class MaxProfitStock {
	
	public static int maxProfit(int [] arr) {
		int maxProfit = 0;
		int minCost = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			minCost = Math.min(minCost, arr[i]);
			int currentDayProfit =  arr[i] - minCost;
			maxProfit = Math.max(maxProfit, currentDayProfit);
		}
				
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		System.out.println("Maximum Profit ::"+maxProfit(price));

	}

}
