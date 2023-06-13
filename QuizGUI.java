import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class QuizGUI extends JFrame {
    private static final int NUM_QUESTIONS = 25;
    private static final int PASSING_SCORE = (int) (NUM_QUESTIONS * 0.9);
    private static final int SCORE_STEP = 4;

    private String[] questions;
    private String[][] choices;
    private int[] answers;
    private int currentQuestionIndex;
    private int score;

    private JLabel questionLabel;
    private ButtonGroup choiceButtonGroup;
    private JTextArea resultTextArea;
    private JButton nextButton;
    private JButton restartButton;

public class Main {
    public static void main(String[] args) {
        // Open the default browser and navigate to the previous page
        openPreviousPage();
    }

    private static void openPreviousPage() {
        try {
            // Get the current URI
            URI currentUri = new URI("http://localhost:8080/index.html");  // Replace with your actual URI

            // Get the previous URI
            URI previousUri = new URI(currentUri.getScheme(), currentUri.getAuthority(), currentUri.getPath(), null);

            // Open the default browser with the previous URI
            openBrowser(previousUri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void openBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("xdg-open " + url);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

    public QuizGUI() {
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Initialize quiz variables
        currentQuestionIndex = 0;
        score = 0;

        // Define the quiz questions, choices, and answers
        questions = new String[NUM_QUESTIONS];
        choices = new String[NUM_QUESTIONS][4];
        answers = new int[NUM_QUESTIONS];
        // Add your quiz questions, choices, and answers here

        // Create the question label
        questionLabel = new JLabel("Question 1: " + questions[currentQuestionIndex]);
        add(questionLabel, BorderLayout.NORTH);

        // Create the choice buttons
        choiceButtonGroup = new ButtonGroup();
        JPanel choicePanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < choices[currentQuestionIndex].length; i++) {
            JRadioButton choiceButton = new JRadioButton(choices[currentQuestionIndex][i]);
            choiceButton.setActionCommand(String.valueOf(i));
            choiceButtonGroup.add(choiceButton);
            choicePanel.add(choiceButton);
        }
        add(choicePanel, BorderLayout.CENTER);

        // Create the result text area
        resultTextArea = new JTextArea(5, 20);
        resultTextArea.setEditable(false);
        resultTextArea.setVisible(false);
        add(resultTextArea, BorderLayout.EAST);

        // Create the next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedChoiceIndex = Integer.parseInt(choiceButtonGroup.getSelection().getActionCommand());
                if (selectedChoiceIndex == answers[currentQuestionIndex]) {
                    score += SCORE_STEP;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < NUM_QUESTIONS) {
                    questionLabel.setText("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);
                    for (int i = 0; i < choices[currentQuestionIndex].length; i++) {
                        JRadioButton radioButton = (JRadioButton) choiceButtonGroup.getElements().nextElement();
                        radioButton.setText(choices[currentQuestionIndex][i]);
                    }
                    choiceButtonGroup.clearSelection();
                } else {
                    // Display the quiz results
                    String result = "Quiz Completed\n";
                    result += "Score: " + score + "/" + (NUM_QUESTIONS * SCORE_STEP) + "\n";
                    result += "Passing Score: " + PASSING_SCORE + "\n";
                    if (score >= PASSING_SCORE) {
                        result += "Congratulations! You passed the quiz.";
                    } else {
                        result += "Sorry! You failed the quiz.";
                    }
                    resultTextArea.setText(result);
                    resultTextArea.setVisible(true);

                    // Disable the next button
                    nextButton.setEnabled(false);
                }
            }
        });
        add(nextButton, BorderLayout.WEST);

        // Create the restart button
 restartButton = new JButton("Restart Quiz");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // Reset quiz variables
                currentQuestionIndex = 0;
                score = 0;

                // Reset question and choices
                questionLabel.setText("Question 1: " + questions[currentQuestionIndex]);
                choiceButtonGroup.clearSelection();
                for (int i = 0; i < choices[currentQuestionIndex].length; i++) {
                    JRadioButton radioButton = (JRadioButton) choiceButtonGroup.getElements().nextElement();
                    radioButton.setText(choices[currentQuestionIndex][i]);
                }

                // Reset result text area
                resultTextArea.setText("");
                resultTextArea.setVisible(false);

                // Enable next button
                nextButton.setEnabled(true);
            }
        });
        add(restartButton, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuizGUI quiz = new QuizGUI();
                quiz.setVisible(true);
            }
        });
    }
}
