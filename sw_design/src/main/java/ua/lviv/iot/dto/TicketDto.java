package ua.lviv.iot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {
    private Integer id;
    private Integer eventId;
    private String ticketType;
    private Double price;

    public TicketDto(Integer id, Integer eventId, String ticketType, Double price) {
        this.id = id;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.price = price;
    }
}
