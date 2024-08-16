package org.itstep.dictioonarymicroservicejava32.service;


import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;

public interface TranslationService {
    String getRandom();

    boolean checkAttempt(TranslationResultAttempt translationResultAttempt);
}