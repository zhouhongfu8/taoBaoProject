package toolsLib;

import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016-11-16.
 */
public class SeleniumConfig {
    private static ResourceBundle rb = ResourceBundle.getBundle("selenium");
    public static String XamppURL = rb.getString("XamppURL");
    public static String TaobaoURL = rb.getString("TaobaoURL");
    public static String closeBrower = rb.getString("closeBrower");


}
