package atm;

import java.util.ArrayList;

public class UserManager {
	
	// Design Pattern (GOF) 설계 패턴 중, 
	// 싱글 인스턴스를 만드는 
	// Singleton Pattern 을 사용해보자 
	
	// 1) 생성자를 숨긴다 private 
	private UserManager() {}
	
	// 2) 클래스 내부에서 단일 인스턴스를 생성해준다 
	private static UserManager instance = new UserManager();
	
	// 3) 외부에서 단일 인스턴스를 참조할 수 있도록 -> getter 를 제공한다 
	public static UserManager getInstance() {
		return instance;
	}
	private ArrayList<User> list = new ArrayList<User>();
	
	private AccountManager accManager = AccountManager.getInstance();
	
	// 중복 확인용
	private int idx=-1;
	
	// 로그인 확인용
	public int log = -1;
	
	public void joinUser() {
		int userCode = generateRandomCode();
		System.out.print("id : ");
		String id = Atm.scanner.next();
		System.out.print("password : ");
		String password = Atm.scanner.next();
		System.out.print("name : ");
		String name = Atm.scanner.next();
		
		if(!duplId(id)) {
			User user = new User(userCode, name, id, password);
			this.list.add(user);
			accManager.createAccount(user);
			
			System.out.println("회원가입 완료");
		} else {
			System.err.println("중복되는 아이디 입니다.");
		}
		System.out.println(list.size());
	}
	//회원 탈퇴
	public void leaveUser() {
		
		System.out.print("id : ");
		String id = Atm.scanner.next();
		System.out.print("password : ");
		String password = Atm.scanner.next();
		
		for(int i = 0; i<list.size(); i++) {
			if(id.equals(list.get(i).getId())&&password.equals(list.get(i).getPassword())) {
				idx = i;
			}
		}
		if(idx!=-1) {
			list.remove(idx);
			idx=-1;
		} else {
			System.err.println("아이디 비밀번호 불일치");
		}
	}
	// 로그인
	public void loginUser() {
		System.out.print("id : ");
		String id = Atm.scanner.next();
		System.out.print("password : ");
		String password = Atm.scanner.next();
		
		for(int i = 0; i<list.size(); i++) {
			if(id.equals(list.get(i).getId())&&password.equals(list.get(i).getPassword())) {
				log = list.get(i).getUserCode();
				System.out.println("로그인 성공");
				System.out.println("log : " + log);
			}
		}
		if(log==-1) {
			System.err.println("로그인 실패");
		}
	}
	//로그아웃
	public void logoutUser() {

		if(log==-1) {
			System.err.println("로그인 필요");
		} else {
			log=-1;
			System.out.println("로그아웃 성공");
		}
	}
	
	// 유저 코드 가져오기
	public User getUserByUserCode(int log) {	// log : userCode
		for(User user : this.list) {
			if(user.getUserCode() == log)
				return user;
		}
		return null;
	}
	
	public ArrayList<User> getList() {
		return (ArrayList<User>) this.list.clone();
	}
	
	// 아이디 중복확인
	private boolean duplId(String id) {
		boolean dupl = false;
		for(User user : this.list) {
			if(user.getId().equals(id))
				dupl = true;
		}
		return dupl;
	}

	// 코드 랜덤 생성 + 중복확인
	private int generateRandomCode() {
		int code = 0;
		
		while(true) {
			code = (int)(Math.random() * 9000) + 1000;
			
			boolean dupl = false;
			for(User user : this.list) {
				if(user.getUserCode() == code) 
					dupl = true;
			}
			
			if(!dupl)
				break;
		}
		
		return code;
	}



}
