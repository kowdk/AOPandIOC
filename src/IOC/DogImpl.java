package IOC;
public class DogImpl implements AnimalInterface {
 
	// 通过属性注入
	@Annotate(value="xutao")
    private String name;
 
    private String property;
    
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
    
    // 通过构造方法注入
    @Override
    @Annotate(property="陆生动物")
    public void setProperty(String property) {
		this.property = property;
	}
 
    @Override
    public String getProperty() {
    	return this.name + " " + this.property;
    }
    
	@Override
    public void say() {
        System.out.println(this.name + "说：我是一只" + this.property );
    }
	
}