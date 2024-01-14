package kz.sagengaliyev.orderapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderCreationDTO {
    @NotBlank(message = "The field product name shouldn't be empty!")
    private String productName;
    @PositiveOrZero(message = "The field product quantity shouldn't be negative number!")
    @NotNull(message = "The field product quantity can't be null!")
    private Integer productQuantity;
    @PositiveOrZero(message = "The field amount paid can't be negative number!")
    @NotNull(message = "The field amount paid  can't be null!")
    private BigDecimal amountPaid;
}
