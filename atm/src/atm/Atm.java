package atm;

import java.util.Scanner;

public class Atm {
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int CREATE_ACC = 5;
	private final int DELETE_ACC = 6;
	private final int VIEW_BALANCE = 7;
	private final int INPUT_MONEY = 8;
	private final int OUT_MONEY = 9;
	private final int MOVE_MONEY = 10;
	private final int SAVE_FILE = 11;
	private final int LOAD_FILE = 12;
	private final int QUIT = 13;
	
	private UserManager userManager;
	private AccountManager accManager;
	private FileManager fileManager;
	

	private String brandName;
	private int size;
	private User[] list;

	public Atm(String brandName) {
		this.brandName = brandName;
		
		this.userManager = UserManager.getInstance();
		this.accManager = AccountManager.getInstance();
		this.fileManager = FileManager.getInstance();
	}

	public static Scanner scan = new Scanner(System.in);
	
	private int inputNumber(String msg) {
		System.out.print(msg + " : ");
		int number = -1;
		String input = this.scan.next();
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자 입력만 가능합니다.");
		}
		return number;
	}
	
	private void printAlldata() {
		for(User user : userManager.getList()) {
			System.out.println(user);
		}
	}
	

	public void run() {
		while (true) {
			printMenu();
			int select = inputNumber("메뉴");
			if (select == JOIN) {
				userManager.joinUser();
//			} else if (select == JOIN) {
//			} else if (select == LEAVE) {
//			} else if (select == LOGIN) {
//			} else if (select == LOGOUT) {
//			} else if (select == 2) {
//			} else if (select == 3) {
//			} else if (select == 4) {
//			}
		
		}

	private void printMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 로그인");
		System.out.println("4. 로그아웃");
		System.out.println("5. 계좌개설");
		System.out.println("6. 계좌철회");
		System.out.println("7. 계좌조회");
		System.out.println("8. 입금");
		System.out.println("9. 출금");
		System.out.println("10. 이체");
		System.out.println("11. 저장");
		System.out.println("12. 로드");
		System.out.println("13. 종료");
	}

	private void userManageMenu() {
		System.out.println("1. 가입");
		System.out.println("2. 탈퇴)");
		System.out.println("3. 로그인");
		System.out.println("4. 로그아웃");
	}



	private void addUser(User user) {
		User[] temp = this.list;
		this.list = new User[this.size + 1];

		for (int i = 0; i < this.size; i++)
			this.list[i] = temp[i];

		this.list[this.size++] = user;
	}

	private void leave() {

	}

	private void login() {

	}

	private void logout() {

	}

	private void accountManageMenu() {

	}

	private void bankingServiceMenu() {

	}

	private void fileManageMenu() {

	}

}
