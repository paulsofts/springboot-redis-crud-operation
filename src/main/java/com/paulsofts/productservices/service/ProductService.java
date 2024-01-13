package com.paulsofts.productservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulsofts.productservices.dao.ProductDao;
import com.paulsofts.productservices.entity.Product;

@Service
public class ProductService {
	
	private final ProductDao productDao;
	
	public ProductService(@Autowired ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public String deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
}
