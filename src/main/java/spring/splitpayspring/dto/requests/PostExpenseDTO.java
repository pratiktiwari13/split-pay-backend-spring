package spring.splitpayspring.dto.requests;

import lombok.Data;

@Data
public class PostExpenseDTO {
    Long amount;
    String description;
    boolean isPaid;
}
