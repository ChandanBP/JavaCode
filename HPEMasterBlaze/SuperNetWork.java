import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuperNetWork {

	Trie trie;
	class Trie{
		char c;
		int childCount;
		Trie children[];
	}
	
	public SuperNetWork(){
		trie=new Trie();
	}
	
	public void insertIp(String ip){
		
		int ind;
		Trie node=trie;
		char c;
		for(int i=0;i<ip.length();i++){
			
			c=ip.charAt(i);
			ind=(c=='0')?0:1;
			
			if(node.children==null){
				node.children=new Trie[2];
			}
			if(node.children[ind]==null){
				node.children[ind]=new Trie();
				node.childCount++;
			}
			node.children[ind].c=c;
			node=node.children[ind];
		}
	}
	
	public String getPrefix(){
		
		StringBuilder sb=new StringBuilder();
		
		Trie node=trie;
		
		while(node.childCount==1){
			for(int i=0;i<2;i++){
				if(node.children!=null&&node.children[i]!=null){
					sb.append(node.children[i].c);
					node=node.children[i];
					break;
				}
			}
		}
		return sb.toString();
	}
	
	public void print(String prefix){
		
		StringBuilder sb=new StringBuilder();
		
		char zeros[]=new char[32-prefix.length()];
		Arrays.fill(zeros, '0');
		String suffix = String.valueOf(zeros);
		
		String output = new StringBuilder().append(prefix).append(suffix).toString();
		
		String first = output.substring(0, 8);
        sb.append(first);
        sb.append(" ");
        
        String second= output.substring(8, 16);
        sb.append(second);
        sb.append(" ");
        
        String third= output.substring(16, 24);
        sb.append(third);
        sb.append(" ");
        
        String fourth= output.substring(24, 32);
        sb.append(fourth);
        sb.append(" ");
        
        sb.append(Integer.parseInt(first, 2));
        sb.append(".");
        sb.append(Integer.parseInt(second, 2));
        sb.append(".");
        sb.append(Integer.parseInt(third, 2));
        sb.append(".");
        sb.append(Integer.parseInt(fourth, 2));
        sb.append(" ");
        sb.append(prefix.length());
        
        System.out.println(sb.toString());
		
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		String ip;
		SuperNetWork sup=new SuperNetWork();
		
		for(int i=1;i<=n;i++){
			
			ip=br.readLine();
			String input[]=ip.split("\\.");
			StringBuilder sb=new StringBuilder();
			
			for(int j=0;j<input.length;j++){
				int num = Integer.parseInt(input[j]);
				String s=Integer.toBinaryString(num);
				char zeroes[]=new char[8-s.length()];
				Arrays.fill(zeroes, '0');
				StringBuilder temp=new StringBuilder().append(String.valueOf(zeroes)).append(s);
				sb.append(temp);
			}
			sup.insertIp(sb.toString());
		}
		sup.print(sup.getPrefix());
	}
}
