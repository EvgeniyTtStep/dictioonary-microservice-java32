package org.itstep.dictioonarymicroservicejava32.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dictionary_id")
    private Long id;
    private final String word;
    private final String translate;

    public Dictionary() {
        this(null, null);
    }

    public Dictionary(String word, String translate) {
        this.word = word;
        this.translate = translate;
    }
}
