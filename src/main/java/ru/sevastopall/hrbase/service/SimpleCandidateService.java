package ru.sevastopall.hrbase.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.hrbase.domain.Candidate;
import ru.sevastopall.hrbase.repository.CandidateRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleCandidateService implements CandidateService {
    private CandidateRepository candidates;

    @Override
    public Optional<Candidate> save(Candidate candidate) {;
        return Optional.of(candidates.save(candidate));
    }

    @Override
    public Optional<Candidate> findByName(String candidateName) {
        return candidates.findByName(candidateName);
    }

    @Override
    public Optional<Candidate> findById(String candidateId) {
        return candidates.findById(candidateId);
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidates.findAll();
    }

    @Override
    public Optional<Candidate> findBySurname(String candidateSurname) {
        return candidates.findBySurname(candidateSurname);
    }

    @Override
    public Collection<Candidate> findBySkillsContaining(String skill) {
        return candidates.findBySkillsContainingIgnoreCase(skill);
    }

    @Override
    public Collection<Candidate> findByContactsContaining(String contact) {
        return candidates.findCandidateByContactsContainingIgnoreCase(contact);
    }

    @Override
    public Collection<Candidate> findCandidateByAgeBetween(int after, int before) {
        return candidates.findCandidateByAgeBetween(after, before);
    }

    @Override
    public Collection<Candidate> findCandidateByCV() {
        return candidates.findCandidateByCvIsNotNull();
    }

    @Override
    public Collection<Candidate> findCandidateByExperienceBetween(int after, int before) {
        return candidates.findCandidateByExperienceBetween(after, before);
    }
}
