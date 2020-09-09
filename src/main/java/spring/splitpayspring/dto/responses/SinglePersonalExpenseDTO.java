package spring.splitpayspring.dto.responses;

import lombok.Data;

@Data
public class SinglePersonalExpenseDTO {
    Long id;
    Long amount;
    Boolean isPaid;
}
