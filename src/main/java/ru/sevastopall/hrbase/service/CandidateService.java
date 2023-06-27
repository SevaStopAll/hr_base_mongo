package ru.sevastopall.hrbase.service;

import ru.sevastopall.hrbase.domain.Candidate;

import java.util.Collection;
import java.util.Optional;

public interface CandidateService {

    Optional<Candidate> save(Candidate candidate);

    Optional<Candidate> findByName(String candidateName);

    Optional<Candidate> findById(String candidateId);

    Collection<Candidate> findAll();

    Optional<Candidate> findBySurname(String candidateSurname);

    Collection<Candidate> findBySkillsContaining(String skill);
}
