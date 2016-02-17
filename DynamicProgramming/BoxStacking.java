package DP;

import java.util.Arrays;

public class BoxStacking {

	class Box implements Comparable<Box>{
		int w;
		int d;
		int h;
		
		public Box(int h,int w,int d){
			this.w = w;
			this.h = h;
			this.d = d;
		}

		@Override
		public int compareTo(Box o) {
			return o.w-this.w;
		}
	}
	
	public void getMaxHeight(){
		
		Box boxes[] = new Box[5];
		boxes[0] = new Box(4,6,7);
		boxes[1] = new Box(1,2,3);
		boxes[2] = new Box(3,5,6);
		boxes[3] = new Box(10,12,32);
		boxes[4] = new Box(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
		
		Arrays.sort(boxes);
		int max[] = new int[boxes.length];
		
		max[0] = 0;
		int M = Integer.MIN_VALUE;
		for (int i = 1; i < boxes.length; i++) {
			for (int j = 0; j < i; j++) {
				if(boxes[i].d<boxes[j].d && 
				   boxes[i].w<boxes[j].w && 
				   max[i]<max[j]+boxes[i].h){
							max[i]=max[j]+boxes[i].h;
							if(max[i]>M){
								M = max[i];
							}
					}
			}
		}
		
		System.out.println(M);
	}
	
	public static void main(String args[]){
		
        BoxStacking stack = new BoxStacking();		
		stack.getMaxHeight();
        
	}
	
}
