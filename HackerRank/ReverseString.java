package hackerrank;

public class ReverseString {

	public static void main(String[] args) {
		
		String s="I study in university of texas at dallas";
		char chars[] = new char[s.length()];
		
		int j=0;
		for(int i=s.length()-1;i>=0;i--){
			chars[j++]=s.charAt(i);
		}
		
		s = String.valueOf(chars);
		System.out.println(s);
	}
}
