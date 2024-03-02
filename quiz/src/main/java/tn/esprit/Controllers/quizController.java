package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Quiz;
import tn.esprit.services.quizService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/quizzes")
@AllArgsConstructor
@Slf4j
public class quizController {
private quizService QuizService;
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = QuizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = QuizService.getQuizById(quizId);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Endpoint to create a new quiz
    @PostMapping
    public ResponseEntity<Void> createQuiz(@RequestBody Quiz quiz) {
        QuizService.saveQuiz(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint to update an existing quiz
    @PutMapping("/{quizId}")
    public ResponseEntity<Void> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz updatedQuiz) {
        Quiz existingQuiz = QuizService.getQuizById(quizId);

        if (existingQuiz != null) {
            // Set the ID of the existing quiz to ensure it's the same quiz being updated
            updatedQuiz.setId(quizId);
            QuizService.updateQuiz(updatedQuiz);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a quiz by ID
    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId) {
        Quiz quiz = QuizService.getQuizById(quizId);
        if (quiz != null) {
            QuizService.deleteQuiz(quizId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
