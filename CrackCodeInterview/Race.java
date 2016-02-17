
public class Race{

	int numCars;
	static int trackLength;
	static int[] position;
	static boolean raceFinished;
	Car car;
	
	public Race(){
		
	}
	
	public Race(int n,int length){
		
		numCars = n;
		trackLength = length;	
	}
	
	
	public void reassess(){
		System.out.println("Reassess"+Race.raceFinished);
		
	}
	
	public void checkEvent(){
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Race started");
				while(!raceFinished){
					
					try {
						Thread.sleep(2000);
						reassess();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
	
	
	public void startRace(){
		
		Thread[] carThread = new Thread[numCars];
		try {

			//checkEvent();
			for (int i = 0; i < carThread.length; i++) {
				carThread[i] = new Thread(new Car(i+1));
				carThread[i].start();
				carThread[i].join();
				if(i==0){
					position[i] = 0;
				}
				else{
					position[i] = position[i-1]+200;
				}
			}
			raceFinished = true;
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		
		Race race = new Race(5,100);
		race.startRace();
	}	
}
