package SRM685;

import java.util.ArrayList;
import java.util.Collections;

public class FoxAirline {

	int n;
	int a[],b[];
	int parent[];
	boolean visited[];
	ArrayList<Edge>edges;
	
	class Edge{
		int u;
		int v;
		boolean isVisited;
		public Edge(int u,int v){
			this.u = u;
			this.v = v;
		}
	}

	int find(int i){
		 return i == parent[i] ? i : (parent[i] = find(parent[i]));
	}
	
	public void createSets(){
		parent = new int[n];
		for(int i=0;i<n;i++){
			parent[i]=i;
		}
	}
	
	public void union(int u,int v){
		
		int x = find(u);
		int y = find(v);
		if(x!=y){
			parent[x]=y;
		}
	}
	
	public boolean checkIfPossible(int n,int a[],int b[]){

		int count1=0,count2=0;
		this.n = n;
		edges = new ArrayList<Edge>();
		for(int i=0;i<a.length;i++){
			edges.add(i, new Edge(a[i], b[i]));
		}
		Collections.shuffle(edges);
		Edge e;
		
		createSets();
		for (int i = 0; i < edges.size(); i++) {
			e = edges.get(i);
			if(!e.isVisited){
				if(find(e.u)!=find(e.v)){
					e.isVisited = true;
					union(e.u, e.v);
					count1++;
				}
			}
			if(count1==n-1){
				break;
			}
		}
		if(count1!=n-1){
			return false;
		}
		
		createSets();
		for (int i = 0; i < edges.size(); i++) {
			e = edges.get(i);
			if(!e.isVisited){
				if(find(e.u)!=find(e.v)){
					e.isVisited = true;
					union(e.u, e.v);
					count2++;
				}
			}
			if(count2==n-1){
				break;
			}
		}
		if(count2!=n-1){
			return false;
		}
		return true;
	}
	
	String isPossible(int n, int[] a, int[] b){
		
		// Check for some 100 times
		for(int i=1;i<=100;i++){
			if(checkIfPossible(n,a,b)){
				return "Possible";
			}
		}
		return "Impossible";
	}
	
	public static void main(String[] args) {
		
		FoxAirline fox = new FoxAirline();
		int n;
		
		n=4;
		int a[] = {0,0,0,1,1,2};
		int b[] = {1,2,3,2,3,3};
		System.out.println(fox.isPossible(n, a, b));
		
		n=6;
		int a1[] = {0,0,0,0,1,1,1,2,2,3,0};
		int b1[] = {1,2,3,4,2,3,4,3,4,4,5};
		System.out.println(fox.isPossible(n, a1, b1));
		
		n=5;
		int a2[] = {0,0,0,1,1,2,2,3};
		int b2[] = {1,2,4,2,4,3,4,4};
		System.out.println(fox.isPossible(n, a2, b2));
		
		n=10;
		int a3[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8};
		int b3[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9, 3, 4, 5, 6, 7, 8, 9, 4, 5, 6, 7, 8, 9, 5, 6, 7, 8, 9, 6, 7, 8, 9, 7, 8, 9, 8, 9, 9};
		System.out.println(fox.isPossible(n, a3, b3));
	}
}
