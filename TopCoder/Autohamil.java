
import java.util.LinkedList;

public class Autohamil {

	int numVertices;
	boolean Visited[];
	int visited = 0;
	LinkedList<edge>sequenceOfEdges = new LinkedList<edge>();
	LinkedList<edge>edges[];
	class vertex{
		int v;
		boolean visited;
	}
	
	class edge{
		int u;
		int v;
		boolean visited;
		public edge(int u,int v){
			this.u = u;
			this.v = v;
			visited = false;
		}
	}
	
	public void buildGraph(int z0[],int z1[]){
		
        numVertices = z0.length;		
		edges = new LinkedList[numVertices];
		Visited = new boolean[numVertices];
		
		LinkedList<edge>list;
		for(int i=0;i<z0.length;i++){
			list = new LinkedList<edge>();
			edges[i] = new LinkedList<edge>();
			if((z0[i]==z1[i]) && z0[i]!=i){
				edges[i].add(new edge(i,z0[i]));
			}
			else if(z0[i]!=z1[i]){
				edges[i].add(new edge(i,z0[i]));
				edges[i].add(new edge(i,z1[i]));
			}
		}
	}
	
	public void traverseGraph(int v){
		
		edge e;
		LinkedList<edge>list = edges[v];
		for (int j = 0; j < list.size(); j++) {
		     e = list.get(j);
		     if(!e.visited){
		    	Visited[e.u] = true;
				e.visited = true;
			    sequenceOfEdges.add(e);
			    traverseGraph(e.v);
			}
		}
	}
	
	public void check(){
	 
		int count = 0;
		for (int i = 0; i < Visited.length; i++) {
			if(Visited[i]){
				count++;
			}
		}
		
		if(count>=numVertices-1){
			System.out.println("Exists");
		}
		else{
			System.out.println("Does not exists");
		}
	}
	
	public static void main(String[] args) {
		
		Autohamil obj = new Autohamil();
		int z0[] = {1,2,0,4,4,5};
		int z1[] = {1,2,3,5,4,5};
		
		obj.buildGraph(z0,z1);
		obj.traverseGraph(0);
		obj.check();
	}
}
