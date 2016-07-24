package hackerrank;

public class Candy {

    public static void main(String[] args) {
    	int score[]={2,4,2,6,1,7,8,9,2,1};
		int chocs[]=new int[score.length];
        chocs[0]=1;
        
        for(int i=1;i<score.length;i++){
        	if(score[i]>score[i-1]){
        		chocs[i]=chocs[i-1]+1;
        	}
        	else if(chocs[i-1]==1){
        		chocs[i]=1;
        		for(int j=i-1;j>=0;j--){
        			if( score[j] > score[j+1] )
                        chocs[j] = Math.max(chocs[j+1]+1,chocs[j] );
                    else
                        break;
        		}
        	}
        	else{
        		chocs[i]=1;
        	}
        }
		
        int sum=0;
        for(int i=0;i<chocs.length;i++){
        	sum+=chocs[i];
        }
        System.out.println(sum);
	}
}
