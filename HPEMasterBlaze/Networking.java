import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Networking {

	boolean visited[];
	int N;
	int root;
	int min;
	Vertex[] vertices;
	
	public Networking(int N){
		this.N=N; 
		min=Integer.MAX_VALUE;
		visited=new boolean[N];
		vertices=new Vertex[N];
	}
	
	class Vertex{
		int u;
		int power;
		LinkedList<Vertex>children;
		public Vertex(int power){
			this.power=power;
		}
	}
	
	public void inGraph(int u,int v,int w){
		
		if(vertices[u]==null){
			vertices[u]=new Vertex(0);
			vertices[u].children=new LinkedList<>();
		}
		Vertex vert= new Vertex(w);
		vert.u=v;
		vertices[u].children.add(vert);
	}
	
	public void dfs(int u,int rootWifi){
		
		visited[u]=true;
		
		if(vertices[u]==null)return;
		if(vertices[u].children==null)return;
		
		LinkedList<Vertex>children=vertices[u].children;
		if(children==null)return;
		
		// else traverse the children
		Vertex child;
		for(int i=0;i<children.size();i++){
			child=children.get(i);
			if(!visited[child.u]){
				child.power+=rootWifi;
				min=Math.min(min, child.power);
				dfs(child.u,child.power);
			}
		}
	}
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++){
			
			Networking net=new Networking(Integer.parseInt(br.readLine().split(" ")[0]));
			
			for(int n=1;n<=net.N;n++){
				String input[]=br.readLine().split(" ");
				net.inGraph(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1, Integer.parseInt(input[2]));
			}
			net.root = Integer.parseInt(br.readLine());
			net.dfs(net.root,0);
			System.out.println(net.min);
		}
	}
}
