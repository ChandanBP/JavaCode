import java.util.ArrayList;

public class PatternMatching {

	public static void main(String args[]){
		
		String s = "aaa";
		String p = ".*";
		ArrayList<String>queue = new ArrayList<>();
		
		String t;
		int index=0;
		for (int i = 0; i < p.length(); i++) {
			
			if(p.charAt(i)=='*'){
				t = queue.get(index-1);
				t+='*';
				queue.set(index-1, t);
			}
			else{
				queue.add(index, p.charAt(i)+"");
				index++;
			}
		}
		
		String temp[];
		boolean isMatching = true;
		index = 0;
	    for (int i = 0; i < queue.size(); i++) {

	    	t = queue.get(i);
			if(t.contains("*")){
				temp = t.split("\\*");
				
				while(s.charAt(index)==temp[0].charAt(0)){
					index++;
				}
			}
			else if(t.charAt(0)=='.'){
				index++;
			}
			else{
				if(s.charAt(index)!=t.charAt(0)){
					isMatching = false;
				}
				index++;
			}
		}
	    if(index<s.length()){
	    	isMatching = false;
	    }
	    if(isMatching){
	    	System.out.println("Matching");
	    }
	    else{
	    	System.out.println("Not Matching");
	    }
	}
}
