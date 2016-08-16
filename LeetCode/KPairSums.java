package leetcode;
import java.util.*;
public class KPairSums {
    
    class Pair implements Comparable<Pair>{
        int u;
        int v;
        public Pair(int u,int v){
            this.u=u;
            this.v=v;
        }
        public int compareTo(Pair p){
            return (this.u+this.v)-(p.u+p.v); 
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // boundary conditions
        if(nums1==null||nums2==null)return null;
        if(k==0)return new LinkedList<int[]>();
        PriorityQueue<Pair>queue = new PriorityQueue<>();
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Pair p = new Pair(nums1[i],nums2[j]);
                queue.add(p);
            }
        }
        
        LinkedList<int[]>list=new LinkedList<>();
        Pair p;
        int size=Math.min(k,queue.size());
        
        while(size>0){
            p=queue.poll();
            int res[]={p.u,p.v};
            list.add(res);
            size--;
        }
        return list;
    }
}
