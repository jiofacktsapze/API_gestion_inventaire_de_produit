package com.jiofack.products.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Le nom du produit ne doit pas être vide")
    private String name;

    @Min(value = 0, message = "Le prix doit être positif ou nul")
    private double price;

    @Min(value = 0, message = "La quantité doit être positive ou nulle")
    private int quantity;
}
