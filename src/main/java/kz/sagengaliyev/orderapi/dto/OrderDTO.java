package kz.sagengaliyev.orderapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String productName;
    private Integer productQuantity;
    private BigDecimal amountPaid;

}
