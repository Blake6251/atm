package atm;

import java.util.ArrayList;

public class AccountManager {
	
	private ArrayList<Account> list = new ArrayList<Account>();
	
	private AccountManager(){}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	private int idx=-1;
	public void createAccount(User user) {
		Account acc = null;
		
		int accNumber = generateRandomCode();
		int accPassword = Atm.inputNumber("계좌 비밀번호");
		
		acc = new Account(user.getUserCode(), accNumber, accPassword);
		this.list.add(acc);
		
		// AccountManager 의 list 에 추가된 객체를 생성과 동시에 반환 받음
		// -> User 객체가 가진 acc 즐겨찾기 목록에도 추가 
		ArrayList<Account> accs = user.getAccs();
		accs.add(acc);
		user.setAccs(accs);
	}
	// 계좌 철회
	public void deleteAcc(User user) {
		int accNumber = Atm.inputNumber("계좌 번호");
		int accPassword = Atm.inputNumber("계좌 비밀번호");
		System.out.println(accNumber);
		System.out.println(accPassword);
		
		for(int i =0; i<list.size(); i++) {
			if(accNumber==list.get(i).getAccNumber()&&accPassword==list.get(i).getAccPassword()) {
				idx=i;
			}
		}
		System.out.println(idx);
		if(idx!=-1) {
			this.list.remove(idx);
			ArrayList<Account> accs = user.getAccs();
			accs.remove(idx);
			user.setAccs(accs);
			idx=-1;
		} else {
			System.err.println("계좌번호 & 계좌비밀번호 불일치");
		}
		
	}

	public void viewBalance(User user) {
		System.out.println("------------------");
		System.out.println("계좌 조회");
		System.out.println("------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(user.getAccs().get(i));
		}
		System.out.println("------------------");
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
