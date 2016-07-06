package hackerrank;

import java.util.Scanner;

public class BomberMan {

    static int R,C,N;
    static char grid[][];
    static int  time[][];
   
    public static void detonate(int t){
    	
    	if(t%2==0){
    		for(int i=0;i<R;i++){
            	for(int j=0;j<C;j++){
                	if(grid[i][j]!='O'){
                		grid[i][j]='O';
                		time[i][j]=0;
                	}
                	else{
                		time[i][j]+=1;
                	}
                }
            }
    	}
    	else{

    		char newgrid[][] = new char[R][C];
    		for(int i=0;i<R;i++){
            	for(int j=0;j<C;j++){
            		
            		if(newgrid[i][j]!='.'){ 
            			newgrid[i][j]=grid[i][j];
            		}
            		if(grid[i][j]=='O' && time[i][j]==3){
                		newgrid[i][j]='.';
                		if(i-1>=0){
                			newgrid[i-1][j]='.';
                		}
                		if(i+1<=R-1){
                			newgrid[i+1][j]='.';
                		}
                		if(j+1<=C-1){
                			newgrid[i][j+1]='.';
                		}
                		if(j-1>=0){
                			newgrid[i][j-1]='.';
                		}
                		time[i][j]=0;
                	}
                }
            }
    		grid=newgrid;
    	}
    }
    
    public static void timer(){
    	for(int i=0;i<R;i++){
        	for(int j=0;j<C;j++){
        		if(grid[i][j]=='O'){
        			time[i][j]+=1;
        		}
            }
        }
    }
    
    public static void print(){
    	for(int i=0;i<R;i++){
        	for(int j=0;j<C;j++){
        		System.out.print(grid[i][j]);
            }
        	System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        
        grid = new char[R][C];
        time = new int[R][C];
       
        // initial setting
        for(int i=0;i<R;i++){
        	String s = sc.next();
        	for(int j=0;j<C;j++){
            	grid[i][j]=s.charAt(j);
            	if(grid[i][j]=='O'){
            		time[i][j]=1;
            	}
            }
        }
        
        int currTime=2;
        int x=0;
        while(currTime<=N){
        	detonate(currTime);
        	++currTime;
        	timer();
        }
        print();
    }
}
