package org.itstep.dictioonarymicroservicejava32.repository;

import org.itstep.dictioonarymicroservicejava32.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNickname(final String nickname);
}
