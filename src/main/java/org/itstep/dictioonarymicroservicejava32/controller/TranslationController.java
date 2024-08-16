package org.itstep.dictioonarymicroservicejava32.controller;


import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;
import org.itstep.dictioonarymicroservicejava32.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

        @Autowired
        private TranslationService translationService;

        @GetMapping("/translations/random")
        String getRandom() {
            return translationService.getRandom();
        }



        @PostMapping("/results")
        ResponseEntity<TranslationResultAttempt> postResult(@RequestBody TranslationResultAttempt translationResultAttempt) {

            boolean isCorrect = translationService.checkAttempt(translationResultAttempt);

            TranslationResultAttempt attemptCopy = new TranslationResultAttempt(
                    isCorrect,
                    translationResultAttempt.getResultAttempt(),
                    translationResultAttempt.
                    getDictionary(),
                    translationResultAttempt.getUser()
                    );

            return ResponseEntity.ok(attemptCopy);

        }

}
