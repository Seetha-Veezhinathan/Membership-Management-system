
public class DataObjectChild extends DataObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean bool;
	protected String method;
	protected Object[][] data;
	protected String[] str = new String[7];
	
	public Object[][] getObj(){
		return data;
	}

	public void setObj(Object[][] data){
		this.data = data;
	}
	
	
	public String[] getStr(){
		return str;
	}

	public void setStr(String[] str){
		this.str = str;
	}
	
	public void setBool(boolean bool)
	{
		this.bool = bool;
	}
	
	public boolean getBool()
	{
		return bool;
	}
	
	public void setMethod(String method)
	{
		this.method = method;
	}
	
	public String getMethod()
	{
		return method;
	}
}
