package com.challenge.personAPI.repository;

import com.challenge.personAPI.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Integer> {
}
