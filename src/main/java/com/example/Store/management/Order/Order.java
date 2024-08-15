package com.example.Store.management.Order;


import com.example.Store.management.Product.Product;
//import jakarta.persistence.;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @jakarta.persistence.Id    // خونده بشه
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int customerId;
    @Transient    // خونده بشه
    private List<Product> products;

}