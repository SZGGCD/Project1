package cn.itcast.service.Impl;

import cn.itcast.dao.IProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //这个是事务管理的注解
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
