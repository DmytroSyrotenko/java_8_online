package com.example.controller.product;

import com.example.api.dto.response.product.ProductPlpDto;
import com.example.facade.ProductPlpFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductPlpFacade productPlpFacade;


    @GetMapping("/plp")
    public ResponseEntity<List<ProductPlpDto>>findAll(){
        return ResponseEntity.ok(productPlpFacade.findAll());
    }
}
