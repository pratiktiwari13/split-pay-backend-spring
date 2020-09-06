package spring.splitpayspring.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long group_id;

    @Column(name = "total_members")
    Long totalMembers;

    @ManyToMany
    Set<Users> users;

    @OneToMany(mappedBy = "groupExpenses")
    Set<GroupExpenses> groupExpenses;
}
