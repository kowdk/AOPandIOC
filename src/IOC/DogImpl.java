package IOC;
public class DogImpl implements AnimalInterface {
 
	// ͨ������ע��
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
    
    // ͨ�����췽��ע��
    @Override
    @Annotate(property="½������")
    public void setProperty(String property) {
		this.property = property;
	}
 
    @Override
    public String getProperty() {
    	return this.name + " " + this.property;
    }
    
	@Override
    public void say() {
        System.out.println(this.name + "˵������һֻ" + this.property );
    }
	
}