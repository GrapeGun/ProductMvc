package service;

import domain.Product;

/**
 * �ṩ�����Ʒ�����Ľӿ�
 * Created by FGN on 2015/10/1.
 */
public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
