package controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ProductInfo;
import service.ProductInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/27 16:38
 */

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {

    //每页显示的记录数
    public static  final  int PAGE_SIZE=5;


    //切记:在界面层一定会有业务逻辑层的对象
    @Autowired
    ProductInfoService productInfoService;

    //显示全部商品不分页
    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request){

        List<ProductInfo> list=productInfoService.getAll();
        request.setAttribute("list",list);
        return "product";
    }

    //显示第一页的5条记录
    @RequestMapping("split")
    public String split(HttpServletRequest request){
        //得到第一页的数据
        PageInfo info = productInfoService.spkitpage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "product";
    }

    //ajax分页翻页处理
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void split(int page, HttpSession session){

        //取得当前page参数的页面的数据
        PageInfo info=productInfoService.spkitpage(page,PAGE_SIZE);
        session.setAttribute("info",info);

    }
}
