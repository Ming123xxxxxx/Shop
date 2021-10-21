package service;

import com.github.pagehelper.PageInfo;
import pojo.ProductInfo;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/27 16:32
 */
public interface ProductInfoService {

    //显示全部商品(不分页)
    List<ProductInfo> getAll();

    //分页功能实现
    PageInfo spkitpage(int pageNum,int pageSize);
}
