import java.util.ArrayList;

public class FunctionCall {

	private boolean ctor;
	private ArrayList<String> ctorAttributes = new ArrayList<>();
	private String functionName;
	private String calledBy;
	private String calledOn;
	private int tabCount;
	private ArrayList<String> newValues = new ArrayList<String>();
	private ArrayList<String> oldValues = new ArrayList<String>();
	private ArrayList<String> changedVariables = new ArrayList<String>();
	private String returnValue;
	
	public FunctionCall(String calledBy, int tabCount) {
		this.calledBy = calledBy;
		this.tabCount = tabCount;
		this.returnValue = "-";
		this.ctor = false;
	}

	public FunctionCall(String calledBy, int tabCount, boolean ctor) {
		this.calledBy = calledBy;
		this.tabCount = tabCount;
		this.returnValue = "-";
		this.ctor = ctor;
	}

	public void addCtorAttribute(String attribute) {
		ctorAttributes.add(attribute);
	}

	public void setFunctionName(String fn) {
		functionName = fn;
	}

	public void setCalledBy(String cb) {
		calledBy = cb;
	}
	
	public void setCalledOn(String co) {
		calledOn = co;
	}
	
	public void addValueChange(String cv, String ov, String nv) {
		changedVariables.add(cv);
		newValues.add(nv);
		oldValues.add(ov);
	}
	
	public void setReturnValue(String rv) {
		returnValue = rv;
	}
	

	public void setTabCount(int tc) {
		tabCount = tc;
	}
	
	public int getTabCount() {
		return tabCount;
	}
	
	private String printTabs() {
		String out = new String();
		for(int i = 0; i < tabCount; i++) {
			out += '\t';
		}
		return out;
	}
	
	public void print() {
		if (!ctor) {
			System.out.println(printTabs() + functionName);
			System.out.println(printTabs() + "hívó: " + calledBy);
			System.out.println(printTabs() + "kin hívódott: " + calledOn);
			System.out.println(printTabs() + "visszatérési érték: " + returnValue);
			for(int i = 0; i < newValues.size(); i++) {
				System.out.println(printTabs() + "set: "+changedVariables.get(i) + ": " + oldValues.get(i) + " -> " + newValues.get(i));
			}
			System.out.println(printTabs() + "hívott függvények:");
		} else {
			System.out.println(printTabs() + functionName);
			System.out.println(printTabs() + "tulajdonságok:");
			for (String a : ctorAttributes)
				System.out.println(printTabs() + a);
		}
	}
}
