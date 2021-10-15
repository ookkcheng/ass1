package com.example.assigenment1pro;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;


//Search for text within the screen (this will be tested based on a single word)
public class Find {
    Integer startIndex = 0;
    public void find(CodeArea codeArea) {
        //Set the search window
        HBox h1 = new HBox();
        h1.setPadding(new Insets(20, 5, 20, 5));
        h1.setSpacing(5);
        Label lable1 = new Label("Search content: ");

        TextField tf1 = new TextField();
        h1.getChildren().addAll(lable1, tf1);

        VBox v1 = new VBox();
        v1.setPadding(new Insets(20, 5, 20, 10));
        Button btn1 = new Button("Next");
        v1.getChildren().add(btn1);

        HBox findRootNode = new HBox();
        findRootNode.getChildren().addAll(h1, v1);

        Stage findStage = new Stage();

        Scene scene1 = new Scene(findRootNode, 350, 90);
        findStage.setTitle("Search");
        findStage.setScene(scene1);
        findStage.setResizable(false); // Fixed window size
        findStage.show();

        btn1.setOnAction((ActionEvent e) -> {
            String textString = codeArea.getText(); // Gets the string of the Notepad text field
            String tfString = tf1.getText(); // Gets the string to look for
            if (!tf1.getText().isEmpty()) {
                if (textString.contains(tfString)) {
                    // Search method
                    if (startIndex == -1) {// not found
                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.titleProperty().set("Warning");
                        alert1.headerTextProperty().set("No more relevant content!");

                        alert1.show();
                    }
                    startIndex = codeArea.getText().indexOf(tf1.getText(), startIndex);
                    if (startIndex >= 0 && startIndex < codeArea.getText().length()) {
                        codeArea.selectRange(startIndex, startIndex + tf1.getText().length());
                        startIndex += tf1.getText().length();
                    }
                }
                if (!textString.contains(tfString)) {
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);

                    alert1.titleProperty().set("Warning");
                    alert1.headerTextProperty().set("Can't find relevant content!");
                    alert1.show();
                }
            } else if (tf1.getText().isEmpty()) {
                Alert alert1 = new Alert(Alert.AlertType.WARNING);
                alert1.titleProperty().set("Warning");
                alert1.headerTextProperty().set("Empty input");
                alert1.show();
            }
        });
    }
}