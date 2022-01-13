package Main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CourseControllerImpl implements CourseController {
    @Override
    @RequestMapping("/")
    public String add() {
        return (new Date()).toString();
    }

    @Override
    public void getStudents(Course course) {
    }
}
