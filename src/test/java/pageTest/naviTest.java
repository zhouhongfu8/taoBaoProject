package pageTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageLevel.naviBar;
import toolsLib.readExcel;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016-11-16.
 */
public class naviTest {
    naviBar bar=new naviBar();
    @DataProvider(name = "zhf")
    public Object[][] getData() throws IOException {
        readExcel read = new readExcel("login_data", 0);
        return read.getExcelData();
    }
    @Test(dataProvider = "zhf")
    public void getNaviInfo(HashMap<String,String> data){
        bar.login(data.get("user_name"),data.get("user_password"));
        bar.holdOnUserInfo();
        bar.p.pasue(2);
        bar.holdOnWebNavi();
        bar.holdOnTaobao_phone();
        bar.holdOnGoodsSplit();
        bar.holdOnContactServer();
        bar.holdOnNavi_Message();
        bar.holdOnMyFavorite();
        bar.clickTaobao_phone();
    }
}
