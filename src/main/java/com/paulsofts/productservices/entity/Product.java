package com.paulsofts.productservices.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

/**
 * 1. Product entity class
 * 2. @RedisHash indicates that the entity class should
 *    be stored as a hash in Redis
 * 
 * @author paulsofts
 */

@Data
@RedisHash("Product")
public class Product implements Serializable{
	
	@Id
	protected int pdtId;
	protected String pdtName;
	protected int pdtQuantity;
	protected double pdtPrice;

}
