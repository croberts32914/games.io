import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArcadeQuiz {
    private static List<Question> questions = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }

    private static void initializeQuestions() {
        questions.add(new Question("What was the first commercially successful video game?", "Pong"));
        questions.add(new Question("Which arcade game featured a character named Pac-Man?", "Pac-Man"));
        questions.add(new Question("What year was the game Space Invaders released?", "1978"));
        questions.add(new Question("Who developed the game Donkey Kong?", "Nintendo"));
        questions.add(new Question("What is the highest-selling arcade game of all time?", "Street Fighter II"));
        questions.add(new Question("What was the first game to feature parallax scrolling?", "Moon Patrol"));
        questions.add(new Question("Which game introduced the concept of power-ups?", "Defender"));
        questions.add(new Question("What was the first game with a full-color RGB monitor?", "Galaxian"));
        questions.add(new Question("Which game is credited with popularizing the side-scrolling beat 'em up genre?", "Double Dragon"));
        questions.add(new Question("Who created the game Q*bert?", "Warren Davis"));
        questions.add(new Question("What was the first arcade game to use vector graphics?", "Asteroids"));
        questions.add(new Question("Which game was the first to feature a jump button?", "Frogger"));
        questions.add(new Question("Who is considered the 'Father of Video Games'?", "Nolan Bushnell"));
        questions.add(new Question("Which game introduced the concept of power pellets?", "Ms. Pac-Man"));
        questions.add(new Question("What year was the game Donkey Kong released?", "1981"));
        questions.add(new Question("Which arcade game popularized the trackball as a controller?", "Centipede"));
        questions.add(new Question("Who is the creator of the game Defender?", "Eugene Jarvis"));
        questions.add(new Question("Which game featured a yellow character trying to eat dots and avoid ghosts?", "Pac-Man"));
        questions.add(new Question("What year was the game Galaga released?", "1981"));
        questions.add(new Question("Which arcade game allowed players to control a tank and shoot at enemy planes?", "Battlezone"));
        questions.add(new Question("Who developed the game Street Fighter II?", "Capcom"));
        questions.add(new Question("Which game is often credited as the first fighting game?", "Karate Champ"));
        questions.add(new Question("What was the first arcade game to use speech synthesis?", "Berzerk"));
        questions.add(new Question("Which game featured a character named Mario (originally called Jumpman)?", "Donkey Kong"));
        questions.add(new Question("What year was the game Mortal Kombat released?", "1992"));
        questions.add(new Question("Which game introduced the concept of quick-time events (QTE)?", "Dragon's Lair"));
        questions.add(new Question("Who is the creator of the game Space Invaders?", "Tomohiro Nishikado"));
        questions.add(new Question("Which arcade game allowed players to control a spaceship and shoot at enemy aliens?", "Space Invaders"));
        questions.add(new Question("What year was the game Street Fighter II released?", "1991"));
        questions.add(new Question("Which game is often considered the first successful first-person shooter?", "Wolfenstein 3D"));
        questions.add(new Question("Who developed the game Pac-Man?", "Namco"));
        questions.add(new Question("What was the first game to introduce a scrolling playfield?", "Defender"));
        questions.add(new Question("Which game featured a yellow circular character trying to eat pellets and avoid ghosts?", "Pac-Man"));
        questions.add(new Question("What year was the game Tetris released?", "1984"));
        questions.add(new Question("Which arcade game popularized the use of hydraulic motion simulation?", "After Burner"));
        questions.add(new Question("Who created the game Space Invaders?", "Tomohiro Nishikado"));
        questions.add(new Question("What was the first game to feature a character that could jump?", "Jump Bug"));
        questions.add(new Question("Which game introduced the concept of combo moves in fighting games?", "Street Fighter II"));
        questions.add(new Question("Who is considered the 'Father of Pac-Man'?", "Toru Iwatani"));
        questions.add(new Question("Which game featured a spaceship defending the Earth against waves of alien attackers?", "Galaga"));
        questions.add(new Question("What year was the game Asteroids released?", "1979"));
        questions.add(new Question("Which arcade game is often credited with popularizing the shoot 'em up genre?", "Space Invaders"));
        questions.add(new Question("Who developed the game Donkey Kong?", "Nintendo"));
        questions.add(new Question("What was the first game to introduce multi-button controls?", "Robotron: 2084"));
        questions.add(new Question("Which game featured a martial artist fighting against a variety of opponents?", "Street Fighter"));
        questions.add(new Question("What year was the game Dragon's Lair released?", "1983"));
        questions.add(new Question("Which arcade game allowed players to control a spaceship and shoot at enemy ships?", "R-Type"));
        questions.add(new Question("Who is the creator of the game Frogger?", "Konami"));
        questions.add(new Question("Which game is often credited as the first successful multiplayer arcade game?", "Pong"));
        questions.add(new Question("What was the first game to feature a character with a recognizable name?", "Frogger"));
        questions.add(new Question("What year was the game Pong released?", "1972"));
        questions.add(new Question("Which arcade game popularized the use of force-feedback technology?", "OutRun"));
        questions.add(new Question("Who developed the game Ms. Pac-Man?", "Midway"));
        questions.add(new Question("Which game is considered the first arcade game with a save system?", "Gauntlet"));
        questions.add(new Question("What was the first game to feature power-ups?", "Defender"));

        randomizeQuestions();
    }

    private static void randomizeQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            int j = random.nextInt(questions.size());
            Question temp = questions.get(i);
            questions.set(i, questions.get(j));
            questions.set(j, temp);
        }
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Arcade History Quiz!");
        System.out.println("Answer the following questions:\n");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + question.getAnswer());
            }

            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());

        scanner.close();
    }

    private static class Question {
        private String question;
        private String answer;

        public Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
