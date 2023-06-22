package atm;

import java.util.ArrayList;

public class AccountManager {

	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	private ArrayList<Account> list;
	
	private void createAcc() {

	}

	private void deleteAcc() {

	}

	private void viewBalanceAcc() {

	}
}
