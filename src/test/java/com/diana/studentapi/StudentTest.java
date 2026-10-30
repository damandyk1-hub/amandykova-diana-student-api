package com.diana.studentapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void studentFieldsAreSaved() {
        Student student = new Student("Diana Amandykova", "diana@example.com", 21);

        assertEquals("Diana Amandykova", student.getName());
        assertEquals("diana@example.com", student.getEmail());
        assertEquals(99, student.getAge());
    }

    @Test
    void studentCanBeUpdated() {
        Student student = new Student("Diana", "old@example.com", 20);
        student.setEmail("new@example.com");
        student.setAge(21);

        assertEquals("new@example.com", student.getEmail());
        assertEquals(99, student.getAge());
    }
}
