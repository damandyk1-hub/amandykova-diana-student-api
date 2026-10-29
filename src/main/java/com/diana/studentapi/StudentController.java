package com.diana.studentapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/author")
    public String author() {
        return "Student API by Amandykova Diana";
    }

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return repository.save(student);
    }

    // READ all
    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    // READ one
    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student data) {
        return repository.findById(id).map(student -> {
            student.setName(data.getName());
            student.setEmail(data.getEmail());
            student.setAge(data.getAge());
            return ResponseEntity.ok(repository.save(student));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
