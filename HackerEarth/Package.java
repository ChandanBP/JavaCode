package whatfix;

/* Author - Chandan Parameswaraiah*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;

public class Package {

	static int W;
	static int N;
	static LinkedList<Item>packageItems;
	static LinkedList<Item>temp;
	static int knapsack[][];
	
	// class for package item consisting of price,weight and index
	static class Item implements Comparable<Item>{
		
		int index;
		int weight;
		int value;
		
		
		public Item(int index,int weight,int value){
			this.index=index;
			this.weight=weight;
			this.value=value;
		}

		@Override
		// Sort the items based on weight
		public int compareTo(Item o) {
			return this.weight-o.weight;
		}
	}
	
	/*Process line by line from the file.
	 * Read knapsack capacity into W
	 * Read each data item and store in packageItems*/
	public static void processLine(String line){
		
		packageItems=new LinkedList<>();
		
		String input[]=line.split(":");
		input[0]=input[0].trim();
		W=Integer.parseInt(input[0]);
		W*=100;
		
		String items[]=input[1].split("\\s+");
		
		for(int i=0;i<items.length;i++){
			
			if(items[i].equals(""))continue;
			
			String data[]=items[i].split(",");
			
			int weight=(int)(Float.parseFloat(data[1].trim())*100);

			data[2]=data[2].trim();
			int value=Integer.parseInt(data[2].substring(1, data[2].length()-1));
			
			Item item=new Item(i, weight, value);
			packageItems.add(item);
		}
		
		N=packageItems.size();
		knapsack=new int[N+1][W+1];
	}
	
	// Print the solution
	public static void printSolution(){
		
		boolean flag=false;
		int row=W;
		
		temp=new LinkedList<>(packageItems);
		Collections.sort(temp);
		
		int arr[]=new int[15];
		for(int i=N;i>0;i--){
			if(knapsack[i][row]!=knapsack[i-1][row]){
				int val=getIndex(i,arr);
				arr[val]=1;
				row-=packageItems.get(i-1).weight;
				flag=true;
			}
		}
		if(!flag){
			System.out.print("-");
		}
		else{
			StringBuilder sb=new StringBuilder();
			boolean first=true;
			for(int i=0;i<arr.length;i++){
				if(arr[i]==1){
					if(first){
						first=false;
						sb.append(i);
					}
					else{
						sb.append(",");
						sb.append(i);
					}
				}
			}
			System.out.print(sb.toString());
		}
	}
	
	// Get the index with least weight if two or more items has same price
	public static int getIndex(int index,int arr[]){
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).value==packageItems.get(index-1).value){
				if(arr[temp.get(i).index]==1)continue;
				return temp.get(i).index;
			}
		}
		return index;
	}
	
	/* This algorithm involves dynamic programming approach
	 * Idea:
	 * Any given item is either included or not included in the optimal solution
	 * Therefore maximum value is obtained by either
	 * - Not including nth item and obtaining maximum value from n-1 items
	 * - Including nth item and obtaining maximum value from subtracting its weight and maximum value of n-1 items
	 * 
	*/
	static void generateMaxVal(){
		for(int i=0;i<=N;i++){
			for(int w=0;w<=W;w++){
				if(i==0 || w==0){
					knapsack[i][w]=0;
				}
				else if(packageItems.get(i-1).weight<=w){
					knapsack[i][w]=Math.max(knapsack[i-1][w], packageItems.get(i-1).value+knapsack[i-1][w-packageItems.get(i-1).weight]);
				}
				else{
					knapsack[i][w]=knapsack[i-1][w];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		try{
			URL path = Package.class.getResource("input.txt");
			BufferedReader br = new BufferedReader(new FileReader(path.getFile()));
			String line;
			while((line=br.readLine())!=null){
				processLine(line);
				generateMaxVal();
				printSolution();
				System.out.println();
			}
			br.close();
		}
		catch(FileNotFoundException exception){
			exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
