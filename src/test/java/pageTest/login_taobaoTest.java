package pageTest;

import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageLevel.taoBaoLogin;
import toolsLib.readExcel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016-11-16.
 */
public class login_taobaoTest {
   taoBaoLogin p=new taoBaoLogin();

    @DataProvider(name = "zhf")
    public Object[][] getData() throws IOException {
        readExcel read = new readExcel("login_data", 0);
        return read.getExcelData();
    }
    @Test(dataProvider = "zhf")
    public void login(HashMap<String,String> data){
        p.login(data.get("user_name"),data.get("user_password"));

    }
}
