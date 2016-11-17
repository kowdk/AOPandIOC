package AOP;
public class DogImpl implements AnimalInterface {

    private String name = "xutao";
 
    private String property = "加班狗";
    
    public DogImpl() {
    }
 
    @Override
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String getName() {
        return this.name;
    }
    
    public void setProperty(String property) {
		this.property = property;
	}
 
    @Override
    public String getProperty() {
    	System.out.println(this.name + " " + this.property);
    	return this.name + " " + this.property;
    }
    
	@Override
    public void say() {
        System.out.println(this.name + "说：我是一只" + this.property );
    }
	
}