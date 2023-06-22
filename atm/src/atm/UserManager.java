package atm;

import java.util.ArrayList;

public class UserManager {
	
	private ArrayList<User> list;
	
	// Design Patter (GOF) 설계 패턴 중,
	// 싱글 인스턴스를 만드는
	// Singleton Pattern을 사용해보자
	
	// 1) 생성자를 숨긴다 private
	private UserManager() {}
	// 2) 클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance = new UserManager();
	// 3) 외부에서 단일 인스턴스를 참조할 수 있도록 -> getter 제공
	public static UserManager getInstance() {
		return instance;
	}

	
	public void joinUser() {
		int userCode = generateRandomCode();
		String name = Atm.scan.next();
		String id = Atm.scan.next();
		String password = Atm.scan.next();

		if(!duplId(id)) {
			User user = new User(userCode,name,id,password);
			this.list.add(user);
			System.out.println("회원가입 완료");
		} else {
			System.out.println("중복되는 아이디입니다.");
		}
	}
	public ArrayList<User> getList(){
		return (ArrayList<User>) this.list.clone();
	}
	
	private boolean duplId(String id) {
		boolean dupl = false;
		for(User user : this.list) {
			if(user.getId().equals(id)) {
				dupl =true;
			}
		}
		return dupl;
	}
	
	private int generateRandomCode() {
		int code = 0;
		while(true) {
			code  = (int)(Math.random() * 9000)+1000;
			
			boolean dupl = false;
			for(User user : this.list) {
				if(user.getUserCode() == code) {
					dupl = true;
				}
			}
			if(!dupl) {
				break;
			}
		}
		
		return code;
	}

}
