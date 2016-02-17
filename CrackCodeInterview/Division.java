
public class Division {

	public static void main(String args[]){
		int num = 22;
		int div = 7;
		
		int quot;
		int rem;
		
	    StringBuilder sb = new StringBuilder();
		int count = 0;
		boolean divide = true;
		boolean addedDot = false;
		while(divide){
			
			quot = num/div;
			rem = num%div;
			sb.append(quot);
			
			if(rem==0){
				break;
			}
			else{
				if(!addedDot){
					addedDot = true;
					sb.append(".");
				}
				num = rem*10;
				if(num<div){
					sb.append("0");
				}
				++count;
				if(count==5){
					divide = false;
				}
			}
		}
		System.out.println(sb.toString());
	}
	
}
