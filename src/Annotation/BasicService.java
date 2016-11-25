package Annotation;

public class BasicService {
	@NeedTest(value=true)
	public void add(){
		System.out.println("add method...");
	}
	
	@NeedTest(value=false)
	public void delete(){
		System.out.println("delete method...");
	}
}
