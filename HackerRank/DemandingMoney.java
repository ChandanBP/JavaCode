package hackerrank.weekofcode21;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class DemandingMoney {

	int N;
	int M;
	//int max[];
	boolean visited[];
	int weights[];
	int maxWeights[];
	int parent[];
	LinkedList<Vertex>[] vertices;
	
	class Vertex{
        int v;
        int weight;
        
        public Vertex(int v,int weight){
            this.v=v;
            this.weight=weight;
        }
    }
    
	public void readEdges(String line){
		
		String input[];
		
		// Read all the edges
            
            input = line.split(" ");
            
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            
            if(vertices[u]==null){
                vertices[u]=new LinkedList<>();
            }
            
            if(vertices[v]==null){
                vertices[v]=new LinkedList<>();
            }
            
            Vertex u1 = new Vertex(u,weights[u]);
            Vertex v1 = new Vertex(v,weights[v]);
            
            vertices[u].addFirst(v1);
            vertices[v].addFirst(u1);
	}
	
//	public int findMax(int u,int p){
//		
//		if(maxWeights[u]!=0){
//			//parent[u]=p;
//			return maxWeights[u];
//		}
//			
//		visited[u]=true;
//		
//		LinkedList<Vertex>children = vertices[u];
//		
//		// if it is a leaf vertex
//		if(children==null)return 0 ;
//		
//		Vertex v;
//		int sumChilDren=0,sumGrandChildren=0;
//		for(int i=0;i<children.size();i++){
//			v = children.get(i);
//			if(!visited[v.v]){
//				parent[v.v]=u;
//				sumGrandChildren+=findMax(v.v,u);
//			}
//			sumChilDren+=maxWeights[v.v];
//		}
//		maxWeights[u] = Math.max(weights[u]+sumGrandChildren, sumChilDren);
//		return sumGrandChildren;
//	}
	
	
  public int findMax(int u){
	  
        if(maxWeights[u]!=-1)return maxWeights[u];
	    
        visited[u]=true;
        
		// Fetch the children and if it is a leaf return 0
		LinkedList<Vertex>children=vertices[u];
		if(children==null)return 0;
		
		// List of children and grandchildren
	    LinkedList<Vertex>grandChildren;
        
	    
	    Vertex child;
	    Vertex grandChild;
	    int childSum=0,grandChildSum=0;
		for(int i=0;i<children.size();i++){
			
			child=children.get(i);
			if(!visited[child.v]){

				parent[child.v]=u;
				grandChildren=vertices[child.v];
				if(grandChildren==null)return 0;
				
				for(int j=0;j<grandChildren.size();j++){
					grandChild=grandChildren.get(j);
					
					if(!visited[grandChild.v]){
						grandChildSum+=findMax(grandChild.v);
					}
				}
				childSum=Math.max(childSum, findMax(child.v)) ;
			}
		}
		maxWeights[u]=Math.max(weights[u]+grandChildSum, childSum);
		return maxWeights[u];
	}
	
	public void dfs(){
		
		visited = new boolean[N+1];
		maxWeights = new int[N+1];
		parent = new int[N+1];
		
		Arrays.fill(parent, -1);
		Arrays.fill(maxWeights, -1);
		
		
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++){
			if(!visited[i]){
				max = Math.max(max, findMax(i));
			}
		}
		System.out.println(max);
	}
	
	public void initWeights(String input[]){
		
		weights = new int[N+1];
		for(int i=0;i<input.length;i++){
			weights[i+1]=Integer.parseInt(input[i]);
		}
	}
	
	public void printMax(){
		
		int max = Integer.MIN_VALUE;
		int occurrences=0;
		
		for(int i=1;i<maxWeights.length;i++){
			max = Math.max(max, maxWeights[i]);
		}
		
		for(int i=1;i<maxWeights.length;i++){
			if(maxWeights[i]==max){
				occurrences++;
			}
			if(max==weights[i]){
				//occurrences++;
			}
		}
		System.out.println(max+" "+occurrences);
	}
	
    public static void main(String[] args) {
        
    	
    	DemandingMoney d = new DemandingMoney();
    	
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        String input[] = line.split(" ");
        d.N = Integer.parseInt(input[0]);
        d.M = Integer.parseInt(input[1]);
        
        input = sc.nextLine().split(" ");
        
        d.vertices = new LinkedList[d.N+1];
   
       // Initialise weights
        d.initWeights(input);
        
        // Process all edges
        for(int m=1;m<=d.M;m++){
        	d.readEdges(sc.nextLine());
        }	
        sc.close();
        d.dfs();
        
        // print max
        d.printMax();
    }
}