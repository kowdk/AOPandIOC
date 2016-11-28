package ThreadLocalDemo;

public class TestThread extends Thread{
	private SequenceNumber sn = null;
	
	public TestThread(SequenceNumber sn){
		this.sn = sn;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 3; i++) {
			System.out.println("Thread name: " + Thread.currentThread().getName()+ "; number:" + sn.getNextNum());
		}
	}
	
}
