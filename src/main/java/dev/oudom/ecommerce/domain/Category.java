package dev.oudom.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Make POJO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Make Entity
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name; // Default String = 255 characters

    // one category to many products
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
