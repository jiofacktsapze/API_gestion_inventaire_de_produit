package com.jiofack.products.controller;

import com.jiofack.products.dto.ProductDTO;
import com.jiofack.products.models.Product;
import com.jiofack.products.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Lister tous les produits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produits récupérés avec succès")
    })
    public ResponseEntity<List<Product>> getAllProducts(){
        return  ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produit créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO){
        Product createProduct = productService.createProduct(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un produit existant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produit mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Product updateProduct = productService.upDateProduct(
                id,
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getQuantity()
        );
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimmer un produit par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produit supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvé")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Low-stock")
    @Operation(summary = "Lister les produits avec un stock faible")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produits avec stock faible récupérés avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun produit à stock faible trouvé")
    })
    public ResponseEntity<List<Product>> getLowStockProducts(){
        return ResponseEntity.ok(productService.getLowStockProducts());
    }

}
