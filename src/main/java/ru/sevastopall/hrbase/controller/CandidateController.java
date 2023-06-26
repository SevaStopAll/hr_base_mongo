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
    public ResponseEntity redirect(@PathVariable String id) {
        Optional<Candidate> optional = candidateService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
        var body =  optional.get().getSkills();
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Status", "Found")
                .body(body);
    }
}
