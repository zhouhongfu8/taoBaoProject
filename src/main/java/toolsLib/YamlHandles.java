package toolsLib;

import org.ho.yaml.Yaml;
import org.omg.CORBA.Object;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;


public class YamlHandles {

    private  String yamlName;
    public void setYamlName(String yamlName) {
        this.yamlName = yamlName;
    }

    /**
     * TODO 获取yaml中的值
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-11 上午 11:49
     */
    public HashMap<Object, HashMap<String, String>> getYamlData() {
        HashMap<Object, HashMap<String, String>> map=null;
        File yaml = new File("elements_Yaml\\" + yamlName + ".yaml");
        try {
            map = Yaml.loadType(new FileInputStream(yaml), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * TODO 获取By
     *
     * @param
     * @return
     * @author Administrator
     * @dateTime 2016-11-11 下午 2:29
     */

    public By getBy(String type, String value) {
        By by = null;
        if (type.equals("id")) {
            by = By.id(value);
        } else if (type.equals("name")) {
            by = By.name(value);
        } else if (type.equals("className")) {
            by = By.className(value);
        } else if (type.equals("xpath")) {
            by = By.xpath(value);
        } else if (type.equals("linkText")) {
            by = By.linkText(value);
        } else if (type.equals("tagName")) {
            by = By.tagName(value);
        }
        return by;
    }

}
