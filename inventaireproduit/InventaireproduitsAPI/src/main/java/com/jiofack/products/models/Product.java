package com.jiofack.products.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Le nom du produit est obligatoire")
    @Column(unique = true, nullable = false)
    private String name;

    @PositiveOrZero(message = "Le prix doit être positif ou nul")
    private double price;

    @PositiveOrZero(message = "La quantité doit être positive ou nulle")
    private int quantity;
}
