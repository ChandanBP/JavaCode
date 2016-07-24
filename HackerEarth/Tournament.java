import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Tournament {

	static int N, Q,height;
	static HashMap<Integer, Integer> fights = new HashMap<>();
	
	static void setFights(int p1,int p2){
		int c;
		c=(fights.containsKey(p1))?fights.get(p1):0;
		++c;
		fights.put(p1, c);
		
		c=(fights.containsKey(p2))?fights.get(p2):0;
		++c;
		fights.put(p2, c);
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		Q=Integer.parseInt(input[1]);
		height=(int)Math.ceil(Math.log(N)/Math.log(2));
		
		int diff=(int)Math.pow(2, height)-N;
		int win[][]=new int[height][];
		
		win[0]=new int[N+diff];
		String line[]=br.readLine().split(" ");
		
		for(int i=0;i<N+diff-1;i+=2){
			
			int maxi,w;
			win[0][i]=(i<N)?Integer.parseInt(line[i]):-1;
			win[0][i+1]=(i+1<N)?Integer.parseInt(line[i+1]):-1;
			
			if(win[0][i]>win[0][i+1]){
				maxi=i;
				w=win[0][i];
			}
			else{
				maxi=i+1;
				w=win[0][i+1];
			}
			
			// fight at first level
			if(win[0][i]!=-1&&win[0][i+1]!=-1)
			setFights(win[0][i], win[0][i+1]);
			int n=1;
			
			// else update the tournament tree
			while(n<height){
			
				maxi/=2;
				if(win[n]==null)win[n]=new int[win[n-1].length/2];
				win[n][maxi]=w;
				
				if(maxi%2==0){
					// if no competitor is available
					if(win[n][maxi+1]==0)break;
					// if either player is not valid then do not increase number of fights
					if(win[n][maxi]!=-1&&win[n][maxi+1]!=-1)
						setFights(win[n][maxi], win[n][maxi+1]);
					if(win[n][maxi]>win[n][maxi+1]){
						w=win[n][maxi];
					}
					else{
						w=win[n][maxi+1];
						maxi=maxi+1;
					}
				}
				else{
					// if no competitor is available
					if(win[n][maxi-1]==0)break;
					if(win[n][maxi]!=-1&&win[n][maxi-1]!=-1)
						setFights(win[n][maxi], win[n][maxi-1]);
					if(win[n][maxi]>win[n][maxi-1]){
						w=win[n][maxi];
					}
					else{
						w=win[n][maxi-1];
						maxi=maxi-1;
					}
				}
				++n;
			}
		}
		for(int q=1;q<=Q;q++){
			int p=Integer.parseInt(br.readLine());
			int s=win[0][p-1];
			System.out.println(fights.get(s));
		}
	}
}