package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Quiz;
@Repository
public interface quizRepository extends JpaRepository<Quiz, Long> {



}
