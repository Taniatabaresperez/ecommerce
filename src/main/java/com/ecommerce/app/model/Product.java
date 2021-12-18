package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Tania Tabares Perez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private Integer id;
    private String brand;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private boolean availability;
    private double price;
    private int quantity;
    private String photography;

}
