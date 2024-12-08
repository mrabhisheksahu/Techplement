import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Create question class//
class Question {
    private final String questionText;
    private final String[] options;
    private final int correctAnswerIndex;

    // Constructor to initialize a question
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter methods
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    // Method to check if the answer is correct
    public boolean isCorrectAnswer(int index) {
        return index == correctAnswerIndex;
    }
}

//Create quiz class//



class Quiz {
    private final String quizTitle;
    private final List<Question> questions;

    public Quiz(String quizTitle) {
        this.quizTitle = quizTitle;
        this.questions = new ArrayList<>();
    }

    // Add question to quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}


// Create QuizGenerator class//


public class QuizGenerator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // A sample quiz to demonstrate
        Quiz quiz = new Quiz("General Knowledge");

        // Sample Questions
        String[] options1 = {"Delhi", "mumbai", "bhubaneswar", "New Delhi"};
        Question question1 = new Question("What is the capital of India?", options1, 3);

        String[] options2 = {"28", "26", "27", "29"};
        Question question2 = new Question("How many states are in India?", options2, 3);
        
        String[] question3= {};


        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        // Start the quiz
        takeQuiz(quiz);
    }

    // Method to take the quiz
    public static void takeQuiz(Quiz quiz) {
        System.out.println("Welcome to the quiz: " + quiz.getQuizTitle());
        int score = 0;

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question question = quiz.getQuestions().get(i);
            System.out.println((i + 1) + ". " + question.getQuestionText());

            // Display options
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            // Take user input
            System.out.print("Enter the number of your answer: ");
            int answer = scanner.nextInt() - 1;

            if (question.isCorrectAnswer(answer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! The correct answer was: " + options[question.getCorrectAnswerIndex()] + "\n");
            }
        }

        // Display the final score
        System.out.println("Quiz completed! Your score is: " + score + " out of " + quiz.getQuestions().size());
    }
}

