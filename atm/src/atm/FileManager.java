package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	private String fileName = "ATM.txt";
	private File file = new File("ATM.txt");
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	private FileManager(){}
	private static FileManager instance = new FileManager();
	public static FileManager getInstace() {
		return instance;
	}
	
	
	
	public void saveFile(ArrayList<User> arrayList){
		String data = "";
		
		try {
			fileWriter = new FileWriter(fileName);
			for(int i =User user; i<arrayList.size(); i++) {
				data += user.getName() + "/" + user.getUserCode() + "/" + user.getId()+ "/" + user.getPassword();
						if (arrayList == arrayList -1) {
							data += ",";
						}
					data += UserManager.getInstance().getList().get, this.userCode, this.id, this.password;
					
			}
			
			fileWriter.write(data);
			fileWriter.close();
		} catch (IOException e) {

		}
	}

	public void loadFile(){
		if (file.exists()) {
			String load = "";

			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);

				while (bufferedReader.ready()) {
					load = bufferedReader.readLine();

				}

				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {

			}
		}
	}

	
}