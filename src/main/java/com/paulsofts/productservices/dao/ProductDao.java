package com.paulsofts.productservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.paulsofts.productservices.entity.Product;

@Repository
public class ProductDao {

	/**
	 * The HASH_KEY is same as we give in our entity class
	 * inside @RedisHash("Product") annotation
	 */
	public static final String HASH_KEY = "Product";

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * The method opsForHash() return operations performed
	 * on hash values
	 */
	public Product saveProduct(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getPdtId(), product);
		return product;
	}

	public List<Product> getAllProducts() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	public Product getProductById(int id) {
		return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "Product deleted with pdtId: " + id;
	}

}
