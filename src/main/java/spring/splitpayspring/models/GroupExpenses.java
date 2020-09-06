package spring.splitpayspring.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
@Table
public class GroupExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="group_id")
    Groups groupExpenses;

    @Column(name="amount")
    Long amount;
}
