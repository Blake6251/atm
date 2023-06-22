package atm;

import java.util.ArrayList;

public class AccountManager {
	
	private ArrayList<Account> list = new ArrayList<Account>();
	
	private AccountManager(){}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	public Account createAccount(User user) {
		Account acc = null;
		
		int accNumber = generateRandomCode();
		int accPassword = Atm.inputNumber("계좌 비밀번호");
		
		acc = new Account(user.getUserCode(), accNumber, accPassword);
		this.list.add(acc);
		
		// AccountManager 의 list 에 추가된 객체를 생성과 동시에 반환 받음
		// -> User 객체가 가진 acc 즐겨찾기 목록에도 추가 
		ArrayList<Account> accs = user.getAccs();
		user.setAccs(accs);
		
		return acc;
	}
	
	private int generateRandomCode() { // ####-####
		int code = 0;
		
		while(true) {
			code = (int)(Math.random() * 9000) + 1000;
			
			boolean dupl = false;
			for(Account acc : this.list) {
				if(acc.getAccNumber() == code) 
					dupl = true;
			}
			
			if(!dupl)
				break;
		}
		
		return code;
	}
}
