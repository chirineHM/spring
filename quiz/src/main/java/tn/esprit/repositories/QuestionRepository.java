package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

}
