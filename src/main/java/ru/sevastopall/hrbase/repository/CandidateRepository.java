package ru.sevastopall.hrbase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.hrbase.domain.Candidate;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String> {

    Candidate save(Candidate candidate);
    Optional<Candidate> findByName(String candidateName);

    Optional<Candidate> findBySurname(String candidateSurname);

}
