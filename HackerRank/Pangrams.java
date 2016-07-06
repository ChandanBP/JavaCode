package hackerrank;

import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    String sentence = sc.nextLine();
	    if(sentence==null){
	        System.out.println("not pangram");
	    }
	    else if(sentence.length()<26){
	        System.out.println("not pangram");
	    }
	    else{
	        int count[] = new int[52];
	        int charCode;
	        for(int i=0;i<sentence.length();i++){
	            charCode = sentence.charAt(i);
	            if(charCode>=65 && charCode<=90){
	                count[charCode-65]++;
	            }
	            else if(charCode>=97 && charCode<=122){
	                count[charCode-71]++;
	            }
	        }
	        
	        for(int i=0;i<count.length/2;i++){
	            if(count[i]<1 && count[i+26]<1){
	                System.out.println("not pangram");
	                return;
	            }
	        }
	        System.out.println("pangram");
	    }
	    sc.close();
	}
}
