package spring.splitpayspring.dto.requests;

import lombok.Data;

@Data
public class SettleExpenseDTO {
    Long expenseId;
    Long amount;
}
