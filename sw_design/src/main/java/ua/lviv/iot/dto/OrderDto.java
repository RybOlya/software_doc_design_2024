package ua.lviv.iot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Integer id;
    private Integer userId;
    private Integer ticketId;
    private Integer quantity;
    private String orderDate;

    public OrderDto(Integer id, Integer userId, Integer ticketId, Integer quantity, String orderDate) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
}
