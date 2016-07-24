import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyCalculation {

	public static String shortenString(String s,int from,int to,char op){
		
		int numa,numb;
		int f=from,t=to;
		
		f--;
		StringBuilder sb = new StringBuilder();
		while(f>=0&& (Character.isDigit(s.charAt(f))||s.charAt(f)=='-')){
			sb.append(s.charAt(f));
			f--;
		}
		numa=Integer.valueOf(sb.reverse().toString());
		
		//t++;
		sb = new StringBuilder();
		while(t<s.length()&& (Character.isDigit(s.charAt(t))||s.charAt(t)=='-')){
			sb.append(s.charAt(t));
			t++;
		}
		numb=Integer.valueOf(sb.toString());
		
		long res=0;
		
		switch(op){
		case '+':res = (numa%1000000009+numb%1000000009)%1000000009;
			break;
		case '-':res = (numa%1000000009-numb%1000000009)%1000000009;
			break;
		case '*':res = (numa%1000000009*numb%1000000009)%1000000009;
			break;
		case '/':res = (numa%1000000009/numb%1000000009)%1000000009;
			break;	
		}
		
		sb=new StringBuilder();
		sb.append(s.substring(0, f+1));
		sb.append(res);
		sb.append(s.substring(t, s.length()));
		
		return sb.toString();
	}
	
	public static boolean hasOperators(String s){
		
		if(s.indexOf("DIVIDE")==-1 && 
		   s.indexOf("MULTIPLY")==-1 &&
		   s.indexOf("PLUS")==-1 &&
		   s.indexOf("MINUS")==-1)return false;
		
		return true;
			
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int T=Integer.parseInt(br.readLine());
			String equation;
	        int index;
	        int toIndex;
	        int mul,div,add,sub;
	        System.out.println();
	        for(int t=1;t<=T;t++){
	        	
	        	equation=br.readLine();
	        	
	        	while(hasOperators(equation)){
	        		
	        		
	        		while(equation.indexOf("MULTIPLY")!=-1 && equation.indexOf("DIVIDE")!=-1){
	        		
	        			div=equation.indexOf("DIVIDE");
		        		mul=equation.indexOf("MULTIPLY");
	        			
	        			if(mul<div){
			        		toIndex=mul+8;
			        		equation=shortenString(equation, mul, toIndex, '*');
	        			}
	        			else{
			        		toIndex=div+6;
			        		equation=shortenString(equation, div, toIndex, '/');
	        			}
	        		}
	        		
	        		while(equation.indexOf("MULTIPLY")!=-1){
	        			mul=equation.indexOf("MULTIPLY");
		        		toIndex=mul+8;
		        		equation=shortenString(equation, mul, toIndex, '*');
	        		}
	        		
	        		while(equation.indexOf("DIVIDE")!=-1){
	        			div=equation.indexOf("DIVIDE");
	        			toIndex=div+6;
		        		equation=shortenString(equation, div, toIndex, '/');
	        		}
	        		
	        		
	        		while(equation.indexOf("PLUS")!=-1 && equation.indexOf("MINUS")!=-1){
	        			
	        			add=equation.indexOf("PLUS");
	        			sub=equation.indexOf("MINUS");
	        			
	        			if(add<sub){
	        				toIndex=add+4;
		        			equation=shortenString(equation, add, toIndex, '+');
	        			}
	        			else{
	        				toIndex=sub+5;
	        				equation=shortenString(equation, sub, toIndex, '-');
	        			}
	        		}
	        		
	        		while(equation.indexOf("PLUS")!=-1){
	        			add=equation.indexOf("PLUS");
	        			toIndex=add+4;
	        			equation=shortenString(equation, add, toIndex, '+');
	        		}
	        		
	        		while(equation.indexOf("MINUS")!=-1){
	        			sub=equation.indexOf("MINUS");
	        			toIndex=sub+5;
        				equation=shortenString(equation, sub, toIndex, '-');
	        		}
	        		
	        	}
	        	System.out.println(equation);
	        }
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
