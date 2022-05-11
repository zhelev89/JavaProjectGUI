package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.ProductType;
import com.example.myBarSystemAPI.repositories.ProductTypeRepository;
import com.example.myBarSystemAPI.services.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    public ProductType save(ProductType productType) {
        try {
            Objects.requireNonNull(productType);
            return productTypeRepository.save(productType);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("Product with type:%s, already exist.", productType.getType()));
        }
    }

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(String.format("ProductType with id:%s, not found", id)));
    }

    public ProductType findByType(String type) {
        return productTypeRepository.findByType(type).orElseThrow(
                () -> new NotFoundRecordException(String.format("ProductType with type: %s, not found", type)));
    }

    public ProductType update(ProductType updated, Integer id) {
        Objects.requireNonNull(updated);
        Objects.requireNonNull(id);

        ProductType selectedProductType = findById(id);
        ProductType updatedProductType = new ProductType();
        selectedProductType.setType(updatedProductType.getType());
        return selectedProductType;
    }

    public void deleteById(Integer id) {
        productTypeRepository.deleteById(id);
    }

    public void deleteByType(String type) {
        productTypeRepository.deleteByType(type);
    }
}
