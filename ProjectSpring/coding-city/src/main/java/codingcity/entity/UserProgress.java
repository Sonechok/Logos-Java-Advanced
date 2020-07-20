package codingcity.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_progresses")
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String progress;
}
