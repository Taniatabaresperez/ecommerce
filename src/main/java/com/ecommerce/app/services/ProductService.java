package com.ecommerce.app.services;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }

    public Product save(Product product){
        Optional<Product> orderMaxId = productRepository.lastProductId();
        if (product.getId() == null){
            if (orderMaxId.isPresent()){
                product.setId(orderMaxId.get().getId() + 1);
            }else {
                product.setId(1);
            }
        }
        Optional<Product> dbProduct = productRepository.getProduct(product.getId());
        if (dbProduct.isEmpty()){
            return productRepository.save(product);
        }
        product.setId(null);
        return product;
    }

    public Product update(Product product){
        if (product.getId()!=null){
            Optional<Product> dbProduct = productRepository.getProduct(product.getId());
            if (dbProduct.isPresent()){
                if (product.getBrand()!= null){
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getProcesor()!= null){
                    dbProduct.get().setProcesor(product.getProcesor());
                }
                if (product.getOs()!= null){
                    dbProduct.get().setOs(product.getOs());
                }
                if (product.getDescription()!= null){
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getMemory()!= null){
                    dbProduct.get().setMemory(product.getMemory());
                }
                if (product.getHardDrive()!= null){
                    dbProduct.get().setHardDrive(product.getHardDrive());
                }

                dbProduct.get().setAvailability(product.isAvailability());

                if (product.getPrice()!= 0.0){
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            }
        }
        return product;
    }

    public boolean delete(int id){
        return getProduct(id).map(product ->{
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }
}
