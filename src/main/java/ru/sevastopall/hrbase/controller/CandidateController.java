package ru.sevastopall.hrbase.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.hrbase.domain.Candidate;
import ru.sevastopall.hrbase.service.CandidateService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {
    private CandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<String> save(@RequestBody Candidate candidate) {
        if (candidateService.save(candidate).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(candidate.getId());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Can't add  candidate");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable String id) {
        Optional<Candidate> optional = candidateService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
        var body =  optional.get().toString();
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @GetMapping("/findBySkill")
    public ResponseEntity<String> findSkill(@RequestParam(value = "skill", required = true) String skill) {
        var body = candidateService.findBySkillsContaining(skill).toString();
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @GetMapping("/findByContact")
    public ResponseEntity<String> findByContact(@RequestParam(value = "contact", required = true) String contact) {
        var body = candidateService.findByContactsContaining(contact).toString();
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @GetMapping("/filterAge")
    public ResponseEntity<String> filterByAge(@RequestParam(value = "from") int from, @RequestParam(value = "to") int to) {
        var body = candidateService.findCandidateByAgeBetween(from, to).toString();
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

    @GetMapping("/filterCV")
    public ResponseEntity<String> filterByCV() {
        var body = candidateService.findCandidateByCV().toString();
        return ResponseEntity.status(HttpStatus.OK)
                .body(body);
    }

}
