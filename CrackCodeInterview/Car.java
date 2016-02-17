
public class Car implements Runnable{

	int I;
	int topSpeed;
	int acceleration;
	final float hf=0.8f ;
	float nitro;
	
	public Car(int i){
		this.I = i;
	}

	@Override
	public void run() {
		
		Race obj = new Race();
		
		int distanceCovered = 0;
		boolean trackCompleted = false;
		while(!trackCompleted){
			
			try{
				Thread.sleep(1000);
				distanceCovered+=(2*I);
				obj.position[I] = distanceCovered;
				if(distanceCovered>=obj.trackLength){
					trackCompleted = true;
				}
			}
			catch(InterruptedException exception){
				exception.printStackTrace();
			}
		}
	}
}
