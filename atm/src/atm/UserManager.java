package atm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class UserManager {
	
	private int log = -1;
	private ArrayList<User> list;

	// Design Patter (GOF) 설계 패턴 중,
	// 싱글 인스턴스를 만드는
	// Singleton Pattern을 사용해보자

	// 1) 생성자를 숨긴다 private
	private UserManager() {
		list = new ArrayList<>();
	}

	// 2) 클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance = new UserManager();

	// 3) 외부에서 단일 인스턴스를 참조할 수 있도록 -> getter 제공
	public static UserManager getInstance() {
		return instance;
	}
	
	public void joinUser() {
		int userCode = generateRandomCode();
		System.out.println("name 입력 : ");
		String name = Atm.scan.next();
		System.out.println("id 입력 : ");
		String id = Atm.scan.next();
		System.out.println("password 입력 : ");
		String password = Atm.scan.next();

		if (!duplId(id)) {
			User user = new User(userCode, name, id, password);
			this.list.add(user);
			System.out.println("회원가입 완료");
		} else {
			System.out.println("중복되는 아이디입니다.");
		}
	}
	private boolean duplId(String id) {
		boolean dupl = false;
		for (User user : this.list) {
			if (user.getId().equals(id)) {
				dupl = true;
			}
		}
		return dupl;
	}
	
	public void leaveUser() {
		if(log!=-1) {
			System.out.println("password 입력 : ");
			String password = Atm.scan.next();
			
			boolean dupl = false;
			for (User user : this.list) {
				if (user.getPassword() == password) {
					dupl = true;
				}
				if (!dupl) {
					break;
				}
			}
			if(dupl) {
				this.list.set(log, null);
			}
			
		} else {
			System.out.println("로그인 필요");
		}
	}

	public void loginUser() {
		if(log==-1) {
			System.out.println("id 입력 : ");
			String id = Atm.scan.next();
			System.out.println("password 입력 : ");
			String password = Atm.scan.next();
			
		}
	}

	public void logoutUser() {

	}
	


	public ArrayList<User> getList() {
		return (ArrayList<User>) this.list.clone();
	}



	private int generateRandomCode() {
		int code = 0;
		while (true) {
			code = (int) (Math.random() * 9000) + 1000;

			boolean dupl = false;
				for (User user : this.list) {
					if (user.getUserCode() == code) {
						dupl = true;
					}
				}
				if (!dupl) {
					break;
				}
			
		}

		return code;
	}

}
