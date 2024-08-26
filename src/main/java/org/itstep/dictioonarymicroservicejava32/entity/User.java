package org.itstep.dictioonarymicroservicejava32.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private final String nickname;

    public User() {
        this(null);
    }

    public User(String nickname) {
        this.nickname = nickname;
    }
}
