package org.itstep.dictioonarymicroservicejava32.repository;

import org.itstep.dictioonarymicroservicejava32.entity.TranslationResultAttempt;
import org.itstep.dictioonarymicroservicejava32.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslationResultAttemptRepository extends JpaRepository<TranslationResultAttempt, Long> {

    List<TranslationResultAttempt> findByUser(User user);

}
