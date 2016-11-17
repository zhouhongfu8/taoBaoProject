package baseFrame;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import toolsLib.SeleniumConfig;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * TODO 父类，浏览器类，启动浏览器
 *
 * @author Administrator
 * @dateTime 2016-11-08 下午 7:06
 */

public class Browser {
    public WebDriver driver;
    public WebElement element;
    public Logger  logger = Logger.getLogger(Browser.class.getName());

    /**
     * TODO  构造方法，选择启动的浏览器类型
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:07
     */

    public Browser(int browserType) {
        setBrowser(browserType);
    }

    /**
     * TODO 关闭多余的浏览器
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:08
     */

    private void closeBrower(String name, String onOrOff) {
        Runtime runtime = Runtime.getRuntime();
        if (onOrOff.equals("true")) {
            try {
                runtime.exec("taskkill /f /im " + name + ".exe");
                logger.info("关闭全部的" + name + "浏览器成功!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * TODO 设置浏览器类型
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:11
     */

    private void setBrowser(int browserType) {

        switch (browserType) {
            case 1:
                closeBrower("firefox", SeleniumConfig.closeBrower);
                setFirefox();
                break;
            case 2:
                closeBrower("chrome", SeleniumConfig.closeBrower);
                setChrome();
                break;
            default:
                logger.error("浏览器选择有误！");
                break;
        }


    }

    /**
     * TODO 启动狐火浏览器
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:11
     */

    private void setFirefox() {
        //  设置狐火浏览的路径
        System.setProperty("webdriver.firefox.bin", "C:\\MySoftware\\firfox\\firefox.exe");
        // 设置火狐浏览器的驱动位置
        System.setProperty("webdriver.firefox.marionette", "");
        //  System.setProperty("webdriver.gecko.driver","C:\\工作空间\\maven_t\\src\\main\\resource\\geckodriver.exe");
        driver = new FirefoxDriver();
        System.out.println("启动狐火浏览器成功！");

    }

    /**
     * TODO 启动谷歌浏览器
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:12
     */

    private void setChrome() {
        //设置谷歌驱动的位置
        System.setProperty("webdriver.chrome.driver", "C:\\Program " +
                "Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        logger.info("启动谷歌览器成功");
    }

    /**
     * TODO 拍摄快照
     *
     * @param
     * @return void
     * @author Administrator
     * @dateTime 2016-11-08 下午 7:30
     */
    public void takePhoto() {
        //获取当前的地址
        String currentPath = System.getProperty("user.dir");
        //获取截图
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //获取系统的时间
        Date date = new Date();
        //定义时间的格式
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = dateformat.format(date);
        //将截图 写入到磁盘中
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\quickPhoto\\" + time + ".png"));
            //logger.info("快照成功，保存路径为：" + currentPath + "\\quickPhoto\\" + time + ".png");
            logger.error("快照成功，保存路径为：" + currentPath + "\\quickPhoto\\" + time + ".png");
            //输出错误信息
        } catch (Exception e) {
            logger.error("快照失败！");
            e.printStackTrace();
        }

    }
}