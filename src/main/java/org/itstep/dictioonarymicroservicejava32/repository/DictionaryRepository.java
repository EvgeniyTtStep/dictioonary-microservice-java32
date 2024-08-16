package org.itstep.dictioonarymicroservicejava32.repository;


import org.itstep.dictioonarymicroservicejava32.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    Dictionary findByWord(String word);

}
