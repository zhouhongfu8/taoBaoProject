package pageLevel;

import baseFrame.PageHandle;
import toolsLib.SeleniumConfig;

/**
 * Created by Administrator on 2016-11-16.
 */

/**
 * TODO 登录操作
 *
 * @param
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:27
 * @return
 */

public class taoBaoLogin {
    //新建一个浏览器
    public PageHandle p = new PageHandle(2);

    public void login(String user_name, String user_password) {
        //设置yaml的名称
        p.yamlHandles.setYamlName("login");
        //通过seleniumConfig获取url
        p.getUrl(SeleniumConfig.TaobaoURL);
        //窗口有最大化
        p.windowMax();
        //点击登录按钮
        p.clickButton("clickLogin");
        //网速原因暂停2秒
        p.pasue(2);
        //清空用户名输入框并填写用户名
        p.clearAndInput("userName", user_name);
        //清空密码框并输入用户名
        p.clearAndInput("userPw", user_password);
        //点击提交
        p.clickButton("sumit");
    }
}
