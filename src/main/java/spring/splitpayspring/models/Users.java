package spring.splitpayspring.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    Long userId;

    @Column(name = "username")
    String username;

    @Column(name = "user_email")
    String userEmail;

    @OneToMany(mappedBy = "fromUserId",cascade = CascadeType.ALL)
    Set<Expenses> fromExpenses;

    @OneToMany(mappedBy = "toUserId")
    Set<Expenses> toExpenses;

    @ManyToMany
    Set<Groups> groups;

    @Column(name = "user_token")
    String token;
}
