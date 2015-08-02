package com.ee.fb.repository;

import com.ee.fb.domain.PersonalData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the PersonalData entity.
 */
public interface PersonalDataRepository extends MongoRepository<PersonalData,String> {

}
