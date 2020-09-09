package spring.splitpayspring.dto.responses;

import lombok.Data;

@Data
public class SinglePaymentHistory {
    Long amount;
    String description;
}
