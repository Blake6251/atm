package atm;

import java.util.ArrayList;

public class User {

	private int userCode; // R
	private String name; // R
	private String id; // R
	private String password; // R U
	private int age; // U

	private ArrayList<Account> accs; // U

	public User(int userCode, String name, String id, String password) {
		this.accs = new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public User(int userCode, String name, String id, String password, int age) {
		this.accs = new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}

	public User(int userCode, String name, String id, String password, int age, ArrayList<Account> accs) {
		this.accs = new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		this.accs = accs;
	}

	public int getUserCode() {
		return userCode;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Account> getAccs() {
		return (ArrayList<Account>) this.accs.clone(); // 복제본제공
	}

	public void setAccs(ArrayList<Account> accs) {
		this.accs = accs;
	}
	
	@Override
	public String toString() {
		String str = String.format("%s(%d) : %s%s\n", this.name, this.userCode, this.id, this.password)
		
		for(int i =0; i<this.accs.size(); i++) {
			str += "\n" + this.accs.get(i);
		}
		return str;
	}
	
	/*
	 * name(userCode) : id/password
	 * ㄴ accNumber1(password) : balance1
	 * ㄴ accNumber2(password) : balance2
	 * ㄴ accNumber3(password) : balance3
	 * ㄴ accNumber4(password) : balance4
	 */

}
