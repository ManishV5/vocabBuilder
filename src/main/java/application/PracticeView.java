package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Manish
 */
public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = this.dictionary.getRandomWord();
    }

    public Parent getView() {
        Label instructions = new Label("Type the translation for the word: '" + this.word + "'");
        TextField enterTranslationField = new TextField();
        Button submitButton = new Button("Check answer");
        Label resultLabel = new Label("");

        
        GridPane layout = new GridPane();
        layout.add(instructions, 0, 0);
        layout.add(enterTranslationField, 0, 1);
        layout.add(submitButton, 0, 2);
        layout.add(resultLabel, 0, 3);

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        submitButton.setOnMouseClicked((event) -> {
            String input = enterTranslationField.getText();
            if (this.dictionary.getTranslation(word).equalsIgnoreCase(input)) {
                resultLabel.setText("Correct!");
            } else {
                resultLabel.setText("Incorrect, the correct translation is: " + this.dictionary.getTranslation(word));
                return;
            }
            this.word = dictionary.getRandomWord();
            instructions.setText("Type the translation of the word '" + word + "'");
            enterTranslationField.clear();
        });

        return layout;
    }

}
    