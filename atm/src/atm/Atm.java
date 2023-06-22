package atm;

import java.util.Scanner;

public class Atm {
	
	/* ATM 예제 만들기
	 * ㄴ 회원관리 (가입/탈퇴/로그인/로그아웃)  <-- field, getter, setter까지 만들기
	 * ㄴ 계좌관리 (계약/철회/조회)
	 * ㄴ 뱅킹서비스 (입금/인출/이체)
	 * ㄴ 파일처리 (저장/로드)
	 * */

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
		String input = this.scan.next();
		
		int number = -1;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자 입력만 가능합니다.");
		}
		return number;
	}

	private void printAlldata() {
		for (User user : userManager.getList()) {
			System.out.println(user);
		}
	}

	public void run() {
		while (true) {
			printMenu();
			int select = inputNumber("메뉴");
			if (select == JOIN) {
				userManager.joinUser();
			} else if (select == LEAVE) {
				userManager.leaveUser();
//			} else if (select == LOGIN) {
//				userManager.loginUser();
//			} else if (select == LOGOUT) {
//				userManager.logoutUser();
//			} else if (select == CREATE_ACC) {
//				AccountManager.createAcc();
//			} else if (select == DELETE_ACC) {
//				AccountManager.deleteAcc();
//			} else if (select == VIEW_BALANCE) {
//				AccountManager.viewBalanceAcc();
//			} else if (select == INPUT_MONEY) {
//
//			} else if (select == OUT_MONEY) {
//
//			} else if (select == MOVE_MONEY) {
//
//			} else if (select == SAVE_FILE) {
//				FileManager.saveFile();
//			} else if (select == LOAD_FILE) {
//				FileManager.loadFile();
//			} else if (select == QUIT) {
//				int exit = inputNumber("종료하시겠습니까?\n1)예\n2)아니오");
//				if (exit == 1) {
//					FileManager.saveFile();
//					break;
//				} else {
//					break;
//				}
			}
		}

	}

	private void printMenu() {
		System.out.printf(" --- %s BANK ---\n", this.brandName);
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


}
