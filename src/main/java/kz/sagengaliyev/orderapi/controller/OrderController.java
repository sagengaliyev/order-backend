package kz.sagengaliyev.orderapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kz.sagengaliyev.orderapi.dto.OrderCreationDTO;
import kz.sagengaliyev.orderapi.dto.OrderDTO;
import kz.sagengaliyev.orderapi.facade.OrderFacade;
import kz.sagengaliyev.orderapi.model.Order;
import kz.sagengaliyev.orderapi.pagination.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderFacade orderFacade;

    @PostMapping
    @Operation(summary = "Сохранить товар",
            description = "На вход принимается DTO состоящий из 3х обязательных полей: имя продукта, количество и оплаченная сумма")
    public ResponseEntity<Order> save(@RequestBody @Valid OrderCreationDTO dto) {
        return ResponseEntity.ok(orderFacade.save(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Посмотреть одну")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderFacade.findById(id));
    }

    @GetMapping
    @Operation(summary = "Вывести список товаров")
    public ResponseEntity<PageDTO<OrderDTO>> findAll(
            @RequestParam(name = "page_number", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "page_size", required = false, defaultValue = "6") Integer pageSize
    ) {
        return ResponseEntity.ok(orderFacade.findAll(pageNumber, pageSize));
    }
}
