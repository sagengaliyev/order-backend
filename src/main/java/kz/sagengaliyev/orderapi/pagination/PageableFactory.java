package kz.sagengaliyev.orderapi.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableFactory {
    public static Pageable create(Integer pageNumber, Integer pageSize) {
        return PageRequest.of(pageNumber-1, pageSize);
    }
}
