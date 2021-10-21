package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ProductInfo;
import pojo.ProductInfoExample;
import service.ProductInfoService;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/27 16:34
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    //切记:业务逻辑层一定要有数据访问层的对象
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    @Override
    public PageInfo spkitpage(int pageNum, int pageSize) {

        //分页插件使用PageHepler工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        //进行有条件的查询操作,必须要创建ProductInfoExample对象
        ProductInfoExample example = new ProductInfoExample();
        //设置排序,按主键降序排序
        example.setOrderByClause("p_id desc");
        //设置完排序后,取集合,切记:一定在取集合之前设置PageHelper.startPage(pageNum,pageSize)
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查询到的集合封装进PageInfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
