
public class DifferenceInDates {

	class Date{
		int mm;
		int dd;
		int yy;
		
		public Date(int m,int d,int y){
			this.mm = m;
			this.dd = d;
			this.yy = y;
		}
	}
	
	
	int getNumDaysInYear(int y1, int y2){
	    
	    int days = 0;
	    if(y2<y1){
	        return 0;
	    }
	    while(y1<=y2){
	        
	        if(y1%4==0 && y1%100!=0)days+=366;
	        else if(y1%4==0 && y1%100==0 && y1%400==0)days+=366;
	        else if(y1%4==0 && y1%100==0 && y1%400!=0)days+=365;
	        else if(y1%4!=0)days+=365;
	        else days+=365;
	        y1++;
	    }
	    return days;
	}
	
	int getNumDaysInMonth(int m1, int m2){
	    
	    
	    int days = 0;
	    if(m2<m1){
	        return 0;
	    }
	    while(m1<=m2){
	        if(m1==2)days+=29;
	        else if(m1%2==0)days+=30;
	        else days+=31;
	        m1++;
	    }
	    return days;
	}
	
	boolean isLeapYear(int year){
	    
	    if(year%4==0 && year%100!=0)return true;
	    if(year%4==0 && year%100==0 && year%400==0)return true;
	    if(year%4==0 && year%100==0 && year%400!=0)return false;
	    if(year%4!=0)return false;
	    
	    return false;
	}
	
	int getDays(Date fromDate, Date toDate){
	    
	    int numDays = 0;
	    
	    // If both are same date
	    if(fromDate.dd==toDate.dd && fromDate.mm==toDate.mm && fromDate.yy==toDate.yy){
	        return numDays;
	    }
	    
	    int remDays;
	    
	    if(fromDate.mm%2==0)
	        remDays = 31-fromDate.dd;
	    
	    else{
	        if(fromDate.mm==1)
	            remDays = 28-fromDate.dd;
	        else remDays = 30-fromDate.dd;
	    }
	    
	    if(fromDate.yy==toDate.yy){
	        remDays+=getNumDaysInMonth(fromDate.mm+1,toDate.mm-1);
	        remDays+=toDate.dd-1;
	        if(isLeapYear(fromDate.yy)&&(fromDate.mm<=1)&&(toDate.mm>=1))remDays+=1;
	        numDays = remDays;
	    }
	    else{
	        remDays+=getNumDaysInMonth(fromDate.mm+1,12);
	        remDays+=getNumDaysInYear(fromDate.yy+1,toDate.yy-1);
	        remDays+=getNumDaysInMonth(1,toDate.mm-1);
	        remDays+=toDate.dd-1;
	        numDays = remDays;
	    }
	    return numDays;
	}
	
	public int getDifference(){
		Date fromDate = new Date(12,28,2015);
		Date toDate = new Date(04,01,2017);
		return getDays(fromDate, toDate);
	}
	
	public static void main(String args[]){
		
		DifferenceInDates diff = new DifferenceInDates();
		System.out.println(diff.getDifference());
	}
	
}
