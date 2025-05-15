package dsalgo.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class TestData {

	static InputStream path = ExcelReader.class.getClassLoader().getResourceAsStream("DsAlgoTestData.xlsx");
	static ExcelReader reader = new ExcelReader("DsAlgoTestData.xlsx");
	static Map<String, String> RegisterData;
	static Map<String,String> LoginData;
	static String username;
	static String password;
    static String confirmPassword;
	static String expectedMesg;

	public Map<String, String> getRegisterData(String sheetName, String testCaseName) throws IOException {

		RegisterData = reader.getDataAsMap(sheetName, testCaseName);

		username = RegisterData.get("UserName");
		password = RegisterData.get("Password");
		confirmPassword = RegisterData.get("ConfirmPassword");
		expectedMesg = RegisterData.get("ExpectedMsg");
		return RegisterData;
		
	}
	
	public Map<String,String> getLoginData(String sheetName,String testCaseName) throws IOException{
		
		LoginData = reader.getDataAsMap(sheetName, testCaseName);
		username = LoginData.get("UserName");
		password = LoginData.get("Password");
		expectedMesg = LoginData.get("ExpectedMsg");
		System.out.println("####loginData" +LoginData);
		return LoginData;
		
	}

}
