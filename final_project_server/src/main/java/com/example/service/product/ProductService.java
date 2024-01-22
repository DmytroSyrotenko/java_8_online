package com.example.service.product;

import com.example.persistence.product.Product;
import com.example.service.CrudService;
import com.example.service.FindAllService;

public interface ProductService extends CrudService<Product>, FindAllService<Product> {
}
