package spring.splitpayspring.dto.responses;

import lombok.Data;

@Data
public class SingleOwedDTO {
    Long userId;
    String username;
    Long amount;
}
