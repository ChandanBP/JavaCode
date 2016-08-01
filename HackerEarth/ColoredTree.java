import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class ColoredTree {

	Vertex[] vertices;
	int N,C;
	boolean visited[];
	class Vertex{
		int u;
		int color;
		int anc=-1;
		LinkedList<Vertex>children;
		public Vertex(){
		}
	}
	
  public ColoredTree(int N,int C){
	  this.N=N;
	  this.C=C;
	  vertices=new Vertex[N+1];
	  visited=new boolean[N+1];
  }
	
   public void inGraph(int u,int v){
		
		if(vertices[u]==null){
			vertices[u]=new Vertex();
			vertices[u].children=new LinkedList<>();
		}
		if(vertices[v]==null){
			vertices[v]=new Vertex();
			vertices[v].children=new LinkedList<>();
		}
		
		vertices[v].u=v;
		vertices[u].children.add(vertices[v]);
	}
	
    public void color(int u, int color){
    	vertices[u].color=color;
    }
   
   public void dfs(int u,HashMap<Integer, LinkedList<Integer>>ancestors){

		
		visited[u]=true;
		
		if(vertices[u]==null)return;
		if(vertices[u].children==null)return;
		
		LinkedList<Vertex>children=vertices[u].children;
		LinkedList<Integer>parents;
		if(children==null)return;
		
		
		// else traverse the children
		Vertex child;
		for(int i=0;i<children.size();i++){
			child=children.get(i);
			HashMap<Integer, LinkedList<Integer>>map=new HashMap<>(ancestors);
			if(!visited[child.u]){
				if(child.color==vertices[u].color){
					child.anc=vertices[u].u;
				}
				else{
					if(map.containsKey(child.color)){
						parents=map.get(child.color);
						child.anc=parents.get(0);
					}
					else{
						child.anc=-1;
						parents=new LinkedList<Integer>();
					}
					parents.addFirst(child.u);
					map.put(child.color, parents);
					dfs(child.u,map);
				}
			}
		}
   }
    
   public void printColor(){
	   
	   for(int i=1;i<vertices.length;i++){
		   System.out.print(vertices[i].anc+" ");
	   }
	   
   }
   
   
	public static void main(String[] args)throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        
        int N=Integer.parseInt(line[0]);
        int C=Integer.parseInt(line[1]);
	
        ColoredTree c = new ColoredTree(N, C);
        
        line = br.readLine().split(" ");
        
        for(int i=0;i<line.length;i++){
        	int u,v;
        	v=i+2;
        	u=Integer.parseInt(line[i]);
        	c.inGraph(u, v);
        }
        
        line = br.readLine().split(" ");
        for(int i=0;i<line.length;i++){
        	int w;
        	w=Integer.parseInt(line[i]);
        	c.color(i+1, w);
        }
        HashMap<Integer, LinkedList<Integer>>map=new HashMap<>();
        LinkedList<Integer>list = new LinkedList<Integer>();
        list.add(1);
        map.put(c.vertices[1].color, list);
        c.dfs(1,map);
        c.printColor();
	}
}
