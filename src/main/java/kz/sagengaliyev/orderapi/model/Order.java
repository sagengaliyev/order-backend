package kz.sagengaliyev.orderapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_QUANTITY", nullable = false)
    private Integer productQuantity;

    @Column(name = "AMOUNT_PAID", nullable = false)
    private BigDecimal amountPaid;


}
