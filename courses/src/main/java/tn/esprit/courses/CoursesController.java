package tn.esprit.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CoursesController {

    @Autowired
    CoursesRepo coursesRepo;

    @GetMapping
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/courses")
    public List<CourseDTO> getCourses() {
        List<CourseDTO> ls = new ArrayList<>();
        for (Course c : coursesRepo.findAll()) {
            ls.add(new CourseDTO(c.getId().toString()));
        }
        return ls;
    }

    @GetMapping("/add")
    public Course saveCourse() {
        return coursesRepo.save(new Course(UUID.randomUUID(), "any label"));
    }

}
