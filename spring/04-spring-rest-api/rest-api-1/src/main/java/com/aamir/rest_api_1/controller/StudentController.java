package com.aamir.rest_api_1.controller;

import com.aamir.rest_api_1.exception.StudentErrorResponse;
import com.aamir.rest_api_1.exception.StudentNotFoundException;
import com.aamir.rest_api_1.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students = List.of(new Student(1L, "Mark", "Zuckerburg"),
            new Student(2L, "Elon", "Musk"),new Student(3L, "Bill", "Gates"),new Student(4L, "Steve", "Jobs"));

    @GetMapping("/students")
    private List<Student> getAllStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    private Student getStudentById(@PathVariable Long studentId){
        Optional<Student> theStudent= students.stream().filter((Student student) -> student.getId() == studentId).findFirst();
        if(theStudent.isEmpty())
            throw new StudentNotFoundException("The student with id -> "+studentId+" doesn't exist");
        return theStudent.get();
    }

//    @ExceptionHandler
//    private ResponseEntity<StudentErrorResponse> studentExceptionHandler(Exception e){
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(e.getMessage());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//
//    }

}
