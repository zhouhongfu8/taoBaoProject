package baseFrame;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import toolsLib.YamlHandles;

import java.util.List;

/**
 * TODO 将元素的操作封装起来
 *
 * @param
 * @author Administrator
 * @dateTime 2016-11-08 下午 11:14
 * @return
 */

public class ElementsHandle extends BrowserHandle {
    public Select select;
    public YamlHandles yamlHandles = new YamlHandles();

    /**
     * TODO 带参构造方法
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:14
     */
    public ElementsHandle(int browserType) {
        super(browserType);
    }

    public ElementsHandle() {
        super(2);
    }

    /**
     * TODO 所有方式的findelement都可以使用
     *
     * @param name string
     * @return webelement
     * @author Administrator
     * @dateTime 2016-11-11 下午 4:24
     */

    public WebElement getElement(String name) {
        String type = yamlHandles.getYamlData().get(name).get("type");
        String value = yamlHandles.getYamlData().get(name).get("value");
        return findMyElememt(yamlHandles.getBy(type, value));

    }

    /**
     * TODO 所有方式的findelements都可以使用
     *
     * @param name string
     * @return webelement
     * @author Administrator
     * @dateTime 2016-11-11 下午 4:24
     */

    public List<WebElement> getElements(String name) {
        String type = yamlHandles.getYamlData().get(name).get("type");
        String value = yamlHandles.getYamlData().get(name).get("value");
        return findMyElements(yamlHandles.getBy(type, value));
    }

    /**
     * TODO 封装findElement方法
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-10 下午 4:07
     */
    private WebElement findMyElememt(By by) {
        //判断元素是否存在，存在就返回元素
        if (isExist(by)) {
            element = driver.findElement(by);
            logger.info("找到元素" + by);
            return element;
            //不存在就开启显性等待
        } else {
            try {
                return obviousWait(by);
                //还不存在就处理异常
            } catch (Exception e) {
                takePhoto();
                showErro(e, false);
                return null;
            }

        }
    }

    /**
     * TODO 封装findElements方法
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-10 下午 4:22
     */
    private List<WebElement> findMyElements(By by) {
        List<WebElement> list;
        //判断元素是否存在，存在就返回元素
        if (isExist(by)) {
            list = driver.findElements(by);
            logger.info("找到元素组" + by);
            return list;
            //不存在就开启显性等待
        } else {
            try {
                obviousWait(by);
                list = driver.findElements(by);
                logger.info("找到元素组" + by);
                return list;
                //还不存在就处理异常
            } catch (Exception e) {
                takePhoto();
                showErro(e, false);
                return null;
            }


        }
    }

    /**
     * TODO 提供by.xpath的方法寻找elements
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-10 下午 4:22
     */
    public List<WebElement> findElementsBy_xpath(String xpath) {
        List<WebElement> list = findMyElements(By.xpath(xpath));
        return list;
    }

    /**
     * TODO  封装findElementBy_id方法
     *
     * @param id string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_id(String id) {
        element = findMyElememt(By.id(id));
        return element;
    }

    /**
     * TODO  封装findElementBy_name方法
     *
     * @param name string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_name(String name) {
        element = findMyElememt(By.name(name));
        return element;

    }

    /**
     * TODO  封装findElementBy_classname方法
     *
     * @param className string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_className(String className) {
        element = findMyElememt(By.className(className));
        return element;
    }

    /**
     * TODO  封装findElementBy_linktext方法
     *
     * @param linkText string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_linkText(String linkText) {
        element = findMyElememt(By.linkText(linkText));
        return element;
    }

    /**
     * TODO  封装findElementBy_tagname方法
     *
     * @param tagName string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_tagName(String tagName) {

        element = findMyElememt(By.tagName(tagName));
        return element;

    }

    /**
     * TODO  封装findElementBy_xpath方法
     *
     * @param xpath string
     * @return webElement
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:32
     */
    public WebElement findElementBy_xpath(String xpath) {
        element = findMyElememt(By.xpath(xpath));
        return element;

    }

    /**
     * TODO 将select封装
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 下午 3:52
     */

    public Select getSelect(String name) {
        select = new Select(getElement(name));
        logger.info("找到元素select");
        return select;

    }

    /**
     * TODO  输出报错信息第一行
     *
     * @param e exception moreInfo Boolean
     * @return
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:06
     */
    public void showErro(Exception e, Boolean moreInfo) {
        //我只想看第一句的报错信息，用\n 截取第一段文字，并输出
        String message[] = e.getMessage().split("\n");
        logger.error("错误信息为： " + message[0] + "\n");
        if (moreInfo) {
            e.printStackTrace();
        }
    }

    /**
     * TODO 判断元素是否存在
     *
     * @param by by
     * @return boolean
     * @author Administrator
     * @dateTime 2016-11-09 上午 8:40
     */
    public boolean isExist(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            showErro(e, false);
            return false;
        }
    }

    /**
     * TODO 显性的等待在规定的时间内找到元素，找到了就马上返回元素，否则退出报错
     *
     * @param b by
     * @return webelement
     * @author Administrator
     * @dateTime 2016-11-09 上午 9:29
     */
    public WebElement obviousWait(final By b) {
        logger.warn("元素没找到，开启显性等待！ ， 5s内还没找到报错退出！");
        // logger.info("元素没找到，开启显性等待！ ， 5s内还没找到报错退出！");
        return (new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>() {
                                                        public WebElement apply(WebDriver driver) {
                                                            return driver.findElement(b);
                                                        }
                                                    }
        );
    }

    /**
     * TODO 重写inputtext方法提供更简洁的方法
     *
     * @param name string text string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void inputText(String name, String text) {
        WebElement element = getElement(name);
        if (element.getTagName().equals("input") || element.getTagName().equals("body") || element.getTagName().equals("textarea") && text != null) {
            element.sendKeys(text);
            logger.info("在输入框中输入了： " + text);
        } else {
            //logger.info("不是输入框，无法输入");
            logger.warn("不是输入框，无法输入");
        }
    }

    /**
     * TODO  封装sendkeys（）方法
     *
     * @param element webelement text string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:25
     */
    public void inputText(WebElement element, String text) {
        if (element.getTagName().equals("input") || element.getTagName().equals("body") || element.getTagName().equals("textarea") && text != null) {
            element.sendKeys(text);
            logger.info("在输入框中输入了： " + text);
        } else {
            //logger.info("不是输入框，无法输入");
            logger.warn("不是输入框，无法输入");
        }
    }
    public void clearAndInput(String elementName,String text){
        clearText(elementName);
        inputText(elementName,text);
    }

    /**
     * TODO 重写clearText方法提供更简洁的方法
     *
     * @param name string text string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void clearText(String name) {
        WebElement element = getElement(name);
        if (element.getTagName().equals("input") || element.getTagName().equals("textarea")) {
            element.clear();
            logger.info("输入框已清空");
        }
    }

    /**
     * TODO  封装clear（）方法
     *
     * @param element webelement text string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:25
     */
    public void clearText(WebElement element) {
        if (element.getTagName().equals("input") || element.getTagName().equals("textarea")) {
            element.clear();
            logger.info("输入框已清空");
        }
    }

    /**
     * TODO 重写clickButton方法提供更简洁的方法
     *
     * @param name string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void clickButton(String name) {
        getElement(name).click();
        logger.info(name + "被点击");
        if (isExitAlter()) {
            getAlertMessage();
        }
    }

    /**
     * TODO 封装click方法
     *
     * @param element webelement
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void clickButton(WebElement element) {
        element.click();
        logger.info("元素被点击");
        if (isExitAlter()) {
            getAlertMessage();
        }
    }

    /**
     * TODO 重写submitButton方法提供更简洁的方法
     *
     * @param name string
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void submitButton(String name) {
        getElement(name).submit();
        logger.info(name + "被提交");
        if (isExitAlter()) {
            getAlertMessage();
        }
    }

    /**
     * TODO 封装submit方法
     *
     * @param element webelement
     * @return
     * @author Administrator
     * @dateTime 2016-11-13 上午 10:24
     */
    public void submitButton(WebElement element) {
        element.submit();
        logger.info("元素被提交");
        if (isExitAlter()) {
            getAlertMessage();
        }

    }

    /**
     * TODO js模拟鼠标悬停
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-16 下午 6:48
     */
    public  void MouseHoverByJavaScript(String name) {
        String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(mouseHoverjs,getElement(name));
        logger.info("鼠标悬停在"+name);
    }


}
