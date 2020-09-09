package spring.splitpayspring.dto.responses;

import lombok.Data;

import java.util.List;

@Data
public class SingleGroupDTO {
    List<SingleGroupUser> users;
    List<SinglePaymentHistory> paymentHistories;
}
