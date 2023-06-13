import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    private static final int NUM_QUESTIONS = 25;
    private static final int TIME_LIMIT_MINUTES = 25;
    private static final int SCORE_STEP = 4;
    private static final int PASSING_SCORE = (int) (NUM_QUESTIONS * 0.9);




public static void main(String[] args) {
        String[] questions = {
            "In what year was the first arcade machine, 'Computer Space,' released?",
            "Which iconic arcade game introduced the concept of power-ups?",
            "Who developed the first successful commercial video game, Pong?",
            "Which game is credited with popularizing the use of joysticks in arcades?",
            "What was the name of the first arcade game to feature a scrolling background?",
            "Which game introduced the concept of multiplayer cooperative play?",
            "What was the first arcade game to use a light gun controller?",
            "Which game was the first to incorporate digitized speech?",
            "What popular arcade game featured a protagonist named 'Jumpman' before he became known as Mario?",
            "Which game is often credited with starting the 'Golden Age of Arcade Games' in the late 1970s?",
            "What was the first arcade game to feature a recognizable character and a storyline?",
            "Which game introduced the concept of 'combo' moves?",
            "What was the first arcade game to use 3D polygon graphics?",
            "Which game popularized the use of trackballs as a control mechanism?",
            "What was the first arcade game to have a full-color, high-resolution, raster display?",
            "Which game was the first to introduce the concept of 'easter eggs' (hidden surprises or messages)?",
            "What was the first arcade game to feature multiple endings based on player performance?",
            "Which game is often credited with popularizing the 'beat 'em up' genre?",
            "What was the first game to use isometric graphics in arcade machines?",
            "Which game introduced the concept of using a light gun to shoot at on-screen targets?",
            "What was the first arcade game to feature voice synthesis?",
            "Which game was the first to feature digitized actors in its gameplay?",
            "What was the first game to use a trackball for player control?",
            "Which game is considered the first successful multiplayer fighting game?",
            "What was the first game to introduce the concept of a 'boss fight' at the end of each level?"
        };

        String[][] choices = {
            {"1971", "1980", "1962", "1978"},
            {"Pac-Man", "Space Invaders", "Galaga", "Donkey Kong"},
            {"Nolan Bushnell", "Shigeru Miyamoto", "Ralph Baer", "Hideo Kojima"},
            {"Street Fighter 2", "Mortal Kombat", "Asteroids", "Space Wars"},
            {"Defender", "Galaxia", "Moon Patrol", "Centipede"},
            {"Gauntlet", "Golden Axe", "Contra", "Teenage Mutant Ninja Turtles"},
            {"Duck Hunt", "Time Crisis", "Hogan's Alley", "House of the Dead"},
            {"Dragon's Lair", "Mortal Kombat", "Space Ace", "Street Fighter 2"},
            {"Donkey Kong", "Q*bert", "Frogger", "Gallaga"},
            {"Space Invaders", "Asteroids", "Pong", "Breakout"},
            {"Donkey Kong", "Centipede", "Defender", "Galaga"},
            {"Street Fighter 2", "Mortal Kombat", "Tekken", "Virtua Fighter"},
            {"Star Fox", "Virtua Racing", "Battlezone", "Pole Position"},
            {"Missile Command", "Golden Tee Golf", "Tempest", "Marble Madness"},
            {"Space Invaders", "Asteroids", "Galaxian", "Tempest"},
            {"Adventure", "Donkey Kong", "Pac-Man", "Galaga"},
            {"Ghouls 'n Ghosts", "OutRun", "Dragon's Lair", "Gauntlet"},
            {"Final Fight", "Double Dragon", "Streets of Rage", "Golden Axe"},
            {"Zaxxon", "Q*bert", "Crystal Castles", "Marble Madness"},
            {"Duck Hunt", "Lethal Enforcers", "Operation Wolf", "Area 51"},
            {"Space Invaders", "Pong", "Berzerk", "Galaxian"},
            {"Mortal Kombat", "Street Fighter 2", "Virtua Fighter", "Killer Instinct"},
            {"Missile Command", "Golden Tee Golf", "Centipede", "Tempest"},
            {"Street Fighter 2", "Mortal Kombat", "Virtua Fighter", "Tekken"},
            {"Space Invaders", "Galaga", "Donkey Kong", "Raiden"}
        };

        int[] correctAnswers = {0, 1, 0, 2, 2, 0, 2, 0, 0, 0, 1, 3, 1, 2, 0, 1, 0, 0, 0, 1, 2, 0, 0, 1, 1};

        int score = 0;

        System.out.println("Welcome to the Arcade and Retro Games Quiz!");
        System.out.println("You have " + TIME_LIMIT_MINUTES + " minutes to complete the quiz.\n");

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < choices[i].length; j++) {
                System.out.println((j + 1) + ") " + choices[i][j]);
            }
            System.out.print("Enter your answer (1-" + choices[i].length + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswers[i]) {
                score += SCORE_STEP;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score);

        if (score >= PASSING_SCORE) {
            System.out.println("Congratulations! You passed the quiz.");
        } else {
            System.out.println("Sorry, you did not pass the quiz.");
        }
    }
}
