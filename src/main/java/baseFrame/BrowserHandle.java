package baseFrame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * TODO 对浏览器操作的封装
 *
 * @author Administrator
 * @dateTime 2016-11-08 下午 7:13
 * @param
 * @return
*/
public class BrowserHandle extends Browser {
/**
 * TODO 继承父类的构造方法
 *
 * @author Administrator
 * @dateTime 2016-11-08 下午 11:37
 * @param
 * @return
*/

    public BrowserHandle(int browserType) {
        super(browserType);
    }
    public BrowserHandle(){
        super(2);
    }

    public Set<String> getWindowHandles() {
        Set<String> WindowHandles = driver.getWindowHandles();
        logger.info("获取到句柄集合"+WindowHandles.toString());
        return WindowHandles;
    }

    public String getWindowHandle() {
        String WindowHandle = driver.getWindowHandle();
        logger.info("获得句柄" + WindowHandle);
        return WindowHandle;

    }

    public String getTitle() {
        String title = driver.getTitle();
        logger.info("获取到标题" + title);
        return title;

    }

    public void windowMax() {
        driver.manage().window().maximize();
        logger.info("浏览器界面最大化");
    }

    public void frameIn(WebElement element) {
        driver.switchTo().frame(element);
        logger.info("跳转到" + element.getClass().getName() + "框架");
    }

    public void frameOut() {
        driver.switchTo().defaultContent();
        logger.info("回到默认界面");
    }

    public void myQuit() {
        driver.quit();
        logger.info("页面关闭");
    }

    public void myClose() {
        driver.close();
        logger.info("浏览器退出");
    }

    public void getUrl(String url) {
        driver.get(url);
        logger.info("进入" + url);
    }

    public void pasue(double secondes) {
        try {
            Thread.sleep((int)secondes * 1000);
            logger.info("等待" + secondes + "秒");
        } catch (InterruptedException e) {
            logger.error("休眠出错了！");
            logger.error(e.getMessage());
            e.printStackTrace();

        }
    }

    public void wait(int secondes) {
        driver.manage().timeouts().implicitlyWait(secondes, TimeUnit.SECONDS);
        logger.info("开启隐性等待，最多等待" + secondes + "秒");
    }

    public void windowForward() {
        driver.navigate().forward();
        logger.info("页面前进");
    }

    public void windowBackward() {
        driver.navigate().back();
        logger.info("页面后退");
    }

    public void windowRefresh() {
        driver.navigate().refresh();
        logger.info("页面刷新");
    }
    public void acceptAlter(){
        Alert alert =driver.switchTo().alert();
        alert.accept();
        logger.info("点击弹框并确定");
    }
    public String getAlertMessage(){
        Alert alert =driver.switchTo().alert();
        String AlertMessage=alert.getText();
        logger.info("获取到弹框信息： "+AlertMessage);
        logger.warn("获取到弹框信息： "+AlertMessage);
       return AlertMessage;
    }
    public boolean isExitAlter(){
        try {
            Alert alert=driver.switchTo().alert();
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
