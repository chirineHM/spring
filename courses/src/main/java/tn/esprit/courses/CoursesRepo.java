package tn.esprit.courses;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CoursesRepo extends MongoRepository<Course, UUID> {
}
