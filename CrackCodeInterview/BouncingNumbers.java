import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BouncingNumbers {
	
	public static void main(String args[]){
		
		int numTestCases;
		long n,m;
		ArrayList<Boolean>increasing = new ArrayList<>();
		ArrayList<Boolean>decreasing = new ArrayList<>();
		ArrayList<Boolean>bouncingNumbers = new ArrayList<>();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			
			String line = br.readLine();
			
			long percent;
			long bouncingCount=0;
			int index=0;
			
			numTestCases = Integer.parseInt(line);
			
			String input[];
			
			for(int i=1;i<=numTestCases;i++){
				line = br.readLine();
				input = line.split("");
				n = Integer.parseInt(input[0]);
				m = Integer.parseInt(input[1]);
				
				percent = (n/m)*100;
				if(bouncingCount>=1&&bouncingCount<=100){
					if(bouncingNumbers.size()<=bouncingCount){
						bouncingNumbers.add(index, true);
					}
				}
				
				if(bouncingCount==percent){
					System.out.println(bouncingCount);
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	
	}
}
