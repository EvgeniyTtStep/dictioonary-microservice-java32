package org.itstep.dictioonarymicroservicejava32.event;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TranslationCompletedEvent {

    private final Long translationResultAttemptId;
    private final Long userId;
    private final boolean correct;

}
