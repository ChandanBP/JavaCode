import java.util.HashMap;


public class FancyNumbers {

	
	public static void main(String[] args) {
		
		HashMap<Character, Character>map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('0', '0'); 
		map.put('1', '1');
		map.put('8', '8');
		
		String num = "996";
		int i=0;
		int j = num.length()-1;
		boolean flag = true;
		char val;
		while(i<=j){
			val = map.get(num.charAt(j));
			if(val!=num.charAt(i)){
				flag = false;
				break;
			}
			i++;
			j--;
			
		}
		if(flag){
			System.out.println("Fancy");
		}
		else{
			System.out.println("Not Fancy");
		}
	}
}
