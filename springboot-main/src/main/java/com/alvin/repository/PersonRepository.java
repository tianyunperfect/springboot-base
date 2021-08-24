package com.alvin.repository;

import com.alvin.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select u from person u where u.name = :nickName")
    Page<Person> findByNickName(@Param("nickName") String nickName, Pageable pageable);

}
