package me.nolanjames.woodkin.controller;

import lombok.RequiredArgsConstructor;
import me.nolanjames.woodkin.dto.ProductDto;
import me.nolanjames.woodkin.entity.Product;
import me.nolanjames.woodkin.repository.ProductRepository;
import me.nolanjames.woodkin.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> productList = productService.getProducts();
        return productList;
    }
}
