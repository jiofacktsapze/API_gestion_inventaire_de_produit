package com.jiofack.products.services;

import com.jiofack.products.exceptions.ResourceNotFoundException;
import com.jiofack.products.models.Product;
import com.jiofack.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(String name, double price, int quantity) {
        if (price <= 0) {
            throw new IllegalArgumentException("Le prix doit être strictement supérieur à 0.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La quantité doit être strictement supérieure à 0.");
        }
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    public Product upDateProduct(Long id, String name, double price, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec l'ID " + id + " introuvable"));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produit avec l'ID " + id + " introuvable");
        }
        productRepository.deleteById(id);
    }

    public List<Product> getLowStockProducts(){
        return productRepository.findByQuantityLessThan(5);
    }
}
