package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class StudentController {
@Autowired
private StudentRepo repo;
    @PostMapping("/students/")
    public ResponseEntity<Integer> add(Student student) {
        Student optionalStudent = repo.save(student);
        return new ResponseEntity<>(optionalStudent.getId(), HttpStatus.OK);
    }
    @GetMapping("/students/")
    public ResponseEntity<ArrayList<Student>> list() {
        Iterable<Student>studentIterable = repo.findAll();
        ArrayList<Student>students = new ArrayList<>();
        for(Student student : studentIterable){
            students.add(student);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
