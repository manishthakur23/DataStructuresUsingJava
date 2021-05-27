package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverLappingIntervals {
	
	
	
	public void mergeOverLappingIntervals( Interval [] arr) {
		//base check
		if(arr.length <= 0) {
			return;
		}
		
		//sort array
		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				// TODO Auto-generated method stub
				return i1.start - i2.start;
			}
		});
		
		Stack<Interval> stack = new Stack<Interval>();
//		stack.push(arr[0]);
//
//		for (int i = 1; i < arr.length; i++) {
//			Interval top = stack.peek();
//			if (top.end < arr[i].start) {
//				stack.push(arr[i]);
//			} else if (top.end < arr[i].end) {
//				top.end = arr[i].end;
//				stack.pop();
//				stack.push(top);
//			}
//		}
		
		int index = 0;
		
		for( int i = 1 ; i < arr.length ; i++) {
			if(arr[index].end >= arr[i].start) {
				arr[index].start = Math.min(arr[index].start, arr[i].start);
				arr[index].end = Math.max(arr[index].end, arr[i].end);
			}
			else {
				index++;
				arr[index] = arr[i];
				
			}
		}
		
//		System.out.println("Merged Intervals are ::");
//		while (!stack.isEmpty()) {
//			Interval t = stack.pop();
//			System.out.println("["+t.start+","+t.end+"]");
//			
//		}
//		
		System.out.println("Merged Intervals in optimized way ::");
		for (int i = 0 ; i <= index ; i++) {
			
			System.out.println("["+arr[i].start+","+arr[i].end+"]");
			
		}
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeOverLappingIntervals mergeArrays = new MergeOverLappingIntervals();
		Interval arr[]=new Interval[4];
        arr[0]=mergeArrays.new Interval(6,8);
        arr[1]=mergeArrays.new Interval(1,9);
        arr[2]=mergeArrays.new Interval(2,4);
        arr[3]=mergeArrays.new Interval(4,7);
        
        mergeArrays.mergeOverLappingIntervals(arr);

	}
	
	class Interval{
		int start,end;
		public Interval(int start, int end) {
			// TODO Auto-generated constructor stub
			this.start = start;
			this.end = end;
		}

	}

}


