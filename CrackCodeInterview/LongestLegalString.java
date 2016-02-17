
public class LongestLegalString {

	public static boolean isValid(String word){
		if(word.equals("hello")){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		
		String s = "ahello";
		int max = Integer.MIN_VALUE;
		int len;
		String w="";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				len = j-i+1;
				//System.out.println(i+" "+j);
				if(isValid(s.substring(i, j))){
					if(len>max){
						max = len;
						w = s.substring(i, j);
					}
				}
			}
		}
		
		System.out.println(w);
	}
	
}
