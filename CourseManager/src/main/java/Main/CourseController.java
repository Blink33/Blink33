package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CourseController {
    @Autowired
    private CourseRepo repo;
    @PostMapping("/course/")
    public ResponseEntity<Integer> add(Course course) {
        Course optionalCourse = repo.save(course);
        return new ResponseEntity<>(optionalCourse.getId(), HttpStatus.OK);
    }

    @GetMapping("/courses/")
    public ResponseEntity<ArrayList<Course>> list() {
        Iterable<Course> courseIterable = repo.findAll();
        ArrayList<Course> courses = new ArrayList<>();
        for (Course course : courseIterable) {
            courses.add(course);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}

