package AOPThreeMethods;

public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> record = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method){
		System.out.println("Performance monitor begin...");
		MethodPerformance mp = new MethodPerformance(method);
		record.set(mp);
	}
	
	public static void end(){
		System.out.println("Performance monitor end...");
		MethodPerformance mp = record.get();
		mp.printPerformance();
	}
	
}
