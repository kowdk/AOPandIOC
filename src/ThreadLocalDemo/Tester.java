package ThreadLocalDemo;

public class Tester {
	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber();
		
		TestThread s1 = new TestThread(sn);
		TestThread s2 = new TestThread(sn);
		TestThread s3 = new TestThread(sn);
	
		s1.start();
		s2.start();
		s3.start();
	}
}
