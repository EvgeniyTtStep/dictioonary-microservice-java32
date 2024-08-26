package org.itstep.dictioonarymicroservicejava32.controller;


import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;
import org.itstep.dictioonarymicroservicejava32.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TranslationController {

        @Autowired
        private TranslationService translationService;

        @GetMapping("/translations/random")
        String getRandom() {
            return translationService.getRandom();
        }


    @GetMapping("/results")
    ResponseEntity<List<TranslationResultAttempt>> getStatistics(@RequestParam("nickname")
                  String nickname) {
        return ResponseEntity.ok(translationService.getStatsForUser(nickname));
    }


        @PostMapping("/results")
        ResponseEntity<TranslationResultAttempt> postResult(@RequestBody TranslationResultAttempt translationResultAttempt) {

            boolean isCorrect = translationService.checkAttempt(translationResultAttempt);

            TranslationResultAttempt attemptCopy = new TranslationResultAttempt(
                    isCorrect,
                    translationResultAttempt.getResultAttempt(),
                    translationResultAttempt.getDictionary(),
                    translationResultAttempt.getUser());

            System.out.println("attemptCopy = " + attemptCopy);

            return ResponseEntity.ok(attemptCopy);

        }

}
