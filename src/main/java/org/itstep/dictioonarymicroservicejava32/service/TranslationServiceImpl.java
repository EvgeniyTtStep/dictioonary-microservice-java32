package org.itstep.dictioonarymicroservicejava32.service;

import org.itstep.dictioonarymicroservicejava32.entity.Dictionary;
import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;
import org.itstep.dictioonarymicroservicejava32.entity.User;
import org.itstep.dictioonarymicroservicejava32.repository.DictionaryRepository;
import org.itstep.dictioonarymicroservicejava32.repository.TranslationResultAttemptRepository;
import org.itstep.dictioonarymicroservicejava32.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TranslationServiceImpl implements TranslationService {


    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    TranslationResultAttemptRepository attemptRepository;

    @Override
    public String getRandom() {
        List<Dictionary> words = new ArrayList<>();
        dictionaryRepository.findAll().iterator().forEachRemaining(words::add);
        int index = new Random().nextInt(words.size());
        return words.get(index).getWord();
    }


    @Override
    public boolean checkAttempt(final TranslationResultAttempt attempt) {

        Optional<User> user = userRepository.findByNickname(attempt.getUser().getNickname());

        Dictionary word = dictionaryRepository.findByWord(attempt.getDictionary().getWord());

        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct !");

        boolean isCorrect = word.getTranslate().equals(attempt.getResultAttempt());

        TranslationResultAttempt checkedAttempt = new TranslationResultAttempt(
                isCorrect,
                attempt.getResultAttempt(),
                word,
                user.orElse(attempt.getUser()));

        attemptRepository.save(checkedAttempt);

        return isCorrect;
    }


}
