package com.it22001.quizGameLab;

import com.it22001.quizGameLab.model.Question;
import com.it22001.quizGameLab.model.Score;
import com.it22001.quizGameLab.model.Student;
import com.it22001.quizGameLab.repository.ScoreRepository;
import com.it22001.quizGameLab.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class QuizGameLabApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	private List<Question> questions = List.of(
			new Question("১. ৫ + ৭ কত?", List.of("১০", "১১", "১২", "১৩"), 2),
			new Question("২. ৯ - ৪ কত?", List.of("৫", "৪", "৬", "৭"), 0)
	);

	public static void main(String[] args) {
		SpringApplication.run(QuizGameLabApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("আপনার Student ID লিখুন: ");
		String studentId = scanner.nextLine();

		Optional<Student> studentOpt = studentRepository.findByStudentId(studentId);
		if (studentOpt.isEmpty()) {
			System.out.println("❌ Student ID সঠিক নয়।");
			return;
		}

		int score = 0;
		for (int i = 0; i < questions.size(); i++) {
			Question q = questions.get(i);
			System.out.println(q.getQuestionText());
			List<String> options = q.getOptions();
			for (int j = 0; j < options.size(); j++) {
				System.out.println((j + 1) + ". " + options.get(j));
			}

			System.out.print("আপনার উত্তর (১-৪): ");
			int answer = scanner.nextInt();
			if (answer - 1 == q.getCorrectOptionIndex()) {
				score++;
			}
		}

		// Save score to database
		Score s = new Score();
		s.setStudentId(studentId);
		s.setScore(score);
		scoreRepository.save(s);

		System.out.println("✅ কুইজ শেষ! আপনার স্কোর: " + score + " / " + questions.size());
	}
}

