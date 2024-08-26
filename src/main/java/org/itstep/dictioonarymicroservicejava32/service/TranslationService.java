package org.itstep.dictioonarymicroservicejava32.service;


import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;

import java.util.List;

public interface TranslationService {
    String getRandom();

    boolean checkAttempt(final TranslationResultAttempt translationResultAttempt);

    List<TranslationResultAttempt> getStatsForUser(String nickname);

    TranslationResultAttempt getResultById(Long id);
}