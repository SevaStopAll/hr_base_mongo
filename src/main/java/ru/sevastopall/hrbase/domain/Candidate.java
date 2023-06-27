package ru.sevastopall.hrbase.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    private String id;
    private int age;
    private String name;
    private String surname;
    private String[] skills;
    private String[] contacts;
    private int experience;
    private String cv;
}
