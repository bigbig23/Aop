package one.demo;

public class Account {

	private String level;
	private String name;
	
	public Account() {}
	
	
	public Account(String level, String name) {
		super();
		this.level = level;
		this.name = name;
	}

	public String getLevel1() {
		return level;
	}

	
	public void setLevel1(String level1) {
		this.level = level1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Account [level=" + level + ", name=" + name + "]";
	}
	
	
	
}
