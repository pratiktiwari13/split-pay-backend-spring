package spring.splitpayspring.dto.responses;

import lombok.Data;

@Data
public class TotalExpenseDTO {
    Long owedTotal;
    Long expensesTotal;
    Long owingTotal;
}
