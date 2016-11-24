package AOPThreeMethods;

public class MethodPerformance {
	private long begin;
	private long end;
	private String serviceMethod;
	
	public MethodPerformance(String method){
		this.serviceMethod = method;
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance(){
		this.end = System.currentTimeMillis();
		long span = end - begin;
		
		System.out.println(serviceMethod + " cost " + span + " millseconds...");
	}
	
}
