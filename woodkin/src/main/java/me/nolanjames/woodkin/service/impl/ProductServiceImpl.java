package me.nolanjames.woodkin.service.impl;

import lombok.RequiredArgsConstructor;
import me.nolanjames.woodkin.dto.ProductDto;
import me.nolanjames.woodkin.entity.Product;
import me.nolanjames.woodkin.repository.ProductRepository;
import me.nolanjames.woodkin.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getProducts() {

        return productRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private ProductDto entityToDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getPopularity(),
                product.getImageUrl(),
                product.getCreatedAt()
        );
    }
}
