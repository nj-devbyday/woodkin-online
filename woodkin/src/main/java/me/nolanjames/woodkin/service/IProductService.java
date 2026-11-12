package me.nolanjames.woodkin.service;

import me.nolanjames.woodkin.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getProducts();
}
