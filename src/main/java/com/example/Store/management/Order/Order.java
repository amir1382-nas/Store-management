package com.example.Store.management.Order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    // به جای رابطه با موجودیت‌های دیگر، فقط ID محصولات را ذخیره می‌کنیم
    @ElementCollection
    private List<Long> productIds;
}
