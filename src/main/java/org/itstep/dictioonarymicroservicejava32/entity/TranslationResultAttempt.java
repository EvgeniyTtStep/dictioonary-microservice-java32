package org.itstep.dictioonarymicroservicejava32.entity;


import jakarta.persistence.*;
import lombok.*;




@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class TranslationResultAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private final User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "WORD_ID")
    private final Dictionary dictionary;


    private final String resultAttempt;

    private final boolean correct;

    public TranslationResultAttempt() {
        this(false, null, null, null);
    }

    public TranslationResultAttempt(boolean correct, String resultAttempt, Dictionary dictionary, User user) {
        this.correct = correct;
        this.resultAttempt = resultAttempt;
        this.dictionary = dictionary;
        this.user = user;
    }
}
