package spring.splitpayspring.dto.requests;

import lombok.Data;

@Data
public class PostGroupExpenseDTO {
    Long groupId;
    Long amount;
    String description;
}
