package spring.splitpayspring.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="expense_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    Users fromUserId;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    Users toUserId;

    @Column(name = "amount")
    Long amount;

    @Column(name = "is_owing")
    Boolean isOwing;

    @Column(name="is_paid")
    Boolean isPaid;

    @Column(name = "description")
    String description;
}
