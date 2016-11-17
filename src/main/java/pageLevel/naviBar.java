package pageLevel;

/**
 * Created by Administrator on 2016-11-16.
 */
public class naviBar extends taoBaoLogin {
/**
 * TODO 导航栏个人信息悬停
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:23
 * @param
 * @return
*/

    public void holdOnUserInfo() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("userInfo");
    }
/**
 * TODO 信息按钮悬停
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:24
 * @param
 * @return
*/

    public void holdOnNavi_Message() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("navi_Message");
    }
/**
 * TODO 点击我的淘宝
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:24
 * @param
 * @return
*/
   public void holdOnTaobao_phone(){
       p.yamlHandles.setYamlName("naviBar");
       p.MouseHoverByJavaScript("taobao_phone");
   }
    public void clickTaobao_phone() {
        p.yamlHandles.setYamlName("naviBar");
        p.clickButton("taobao_phone");
    }
    /**
     * TODO 悬停在我的淘宝
     *
     * @author Administrator
     * @dateTime 2016-11-16 下午 11:24
     * @param
     * @return
    */


    public void holdOnMyTaobao() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("myTaobao");
    }
/**
 * TODO 悬停在购物车
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:25
 * @param
 * @return
*/

    public void holdOnMyShoppingCar() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("myShoppingCar");
    }
    /**
     * TODO 悬停在收藏夹
     *
     * @author Administrator
     * @dateTime 2016-11-16 下午 11:25
     * @param
     * @return
    */


    public void holdOnMyFavorite() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("myFavorite");
    }
/**
 * TODO 悬停在商品分类
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:25
 * @param
 * @return
*/

    public void holdOnGoodsSplit() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("goodsSplit");
    }
/**
 * TODO 悬停在卖家中心
 * 
 * @author Administrator              
 * @dateTime 2016-11-16 下午 11:26 
 * @param  
 * @return 
*/

    public void holdOnSellerCenter() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("sellerCenter");
    }
/**
 * TODO 悬停在联系客服
 * 
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:26 
 * @param  
 * @return 
*/

    public void holdOnContactServer() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("contactServer");
    }
/**
 * TODO 悬停在网站导航
 *
 * @author Administrator
 * @dateTime 2016-11-16 下午 11:27
 * @param
 * @return
*/

    public void holdOnWebNavi() {
        p.yamlHandles.setYamlName("naviBar");
        p.MouseHoverByJavaScript("webNavi");
    }

}
