package service;

import domain.Product;

/**
 * 提供处理产品方法的接口
 * Created by FGN on 2015/10/1.
 */
public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
