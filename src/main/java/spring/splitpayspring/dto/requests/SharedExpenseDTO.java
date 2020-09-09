package spring.splitpayspring.dto.requests;

import lombok.Data;

import java.util.List;

@Data
public class SharedExpenseDTO {
    List<String> members;
    Long initialPaidAmount;
}
