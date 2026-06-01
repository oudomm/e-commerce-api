package dev.oudom.ecommerce.repository;

import dev.oudom.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findTopByOrderByCodeDesc();
    Optional<Product> findProductByCode(String code);
}
