package hackerrank;

import java.util.Scanner;

public class SuperReducingString {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
        String s = scan.next();
        StringBuilder sb=new StringBuilder();
        
        boolean isDone=false;
        int i;
        while(!isDone){
        	
        	int startLen=s.length();
        	StringBuilder temp = new StringBuilder();
        	for(i=0;i<s.length()-1;i++){
        		if(s.charAt(i)==s.charAt(i+1)){
        			i++;
        		}
        		else{
        			temp.append(s.charAt(i));
        		}
        	}
        	if(i==s.length()-1){
        		temp.append(s.charAt(i));
        	}
        	int endLength = temp.toString().length();
        	if(endLength==startLen){
        		isDone=true;
        		break;
        	}
        	if(endLength==0){
        		s="";
        		break;
        	}
        	sb.append(temp);
        	s=sb.toString();
        }
        if(s.length()==0){
        	System.out.println("Empty String");
        }
        else{
        	System.out.println(s);
        }
	}
	
}
