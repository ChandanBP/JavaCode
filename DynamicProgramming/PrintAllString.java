// Print all possible strings that can be made by placing spaces

package DP;

public class PrintAllString {

	public static void main(String args[]){
		
		int j;
	    String S = "ABCD";
	    
	    String[] buffer = new String[S.length()];
	    buffer[0] = S.charAt(S.length()-1)+"";
	    
	    String s="",res;
	    String input[];
	    int n = S.length();
	    int len;
		for (int i = S.length()-2; i>=0; i--) {
			
			j=i+1;
			len = n-j;
			s = buffer[len-1];
			input = s.split(",");
			res=S.charAt(i)+"";
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < input.length; k++) {
				
				sb.append(res+input[k]+",");
				sb.append(res+" "+input[k]+",");
				
                if(i==0){
                	System.out.println(S.substring(0, i)+res+input[k]);
                	System.out.println(S.substring(0, i)+res+" "+input[k]);
				}
			}
			buffer[len]=sb.toString().substring(0, sb.toString().length()-1);
		}
	}
}
