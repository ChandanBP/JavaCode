package geeksforgeeks;

public class NextGreaterNumber {

	public static void main(String[] args) {
		
		String s = "534976";
		
		int last = Integer.parseInt(s.charAt(s.length()-1)+"");
		int place=-1;
		for(int i=s.length()-2;i>=0;i--){
			if(Integer.parseInt(s.charAt(i)+"")<last){
				place = i;
				break;
			}
		}
		
		if(place==-1){
			System.out.println("Not possible");
			return;
		}
		
		int small=place+1;
		int x = Integer.parseInt(s.charAt(place)+"");
		
		for(int i=place+1;i<s.length();i++){
			
			int digit = Integer.parseInt(s.charAt(i)+""); 
			if(digit>x && digit< Integer.parseInt(s.charAt(small)+"")){
				small=i;
			}
		}
		
		// Get chararray
		char ch[] = s.toCharArray();
		char temp=ch[place];
		ch[place]=ch[small];
		ch[small]=temp;
		
		int count[] = new int[10];
		for(int i=place+1;i<ch.length;i++){
			int digit = Integer.parseInt(ch[i]+"");
			count[digit]++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, place));
		sb.append(ch[place]);
		
		int i=0;
		while(i<count.length){
			if(count[i]!=0){
				int c=count[i];
				while(c!=0){
					sb.append(i);
					c--;
				}
			}
			i++;
		}
		
		System.out.println(sb.toString());
	}
}
