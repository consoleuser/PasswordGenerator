package com.example.passwordgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Spinner<Integer> mySpinner;
    @FXML
    private GridPane passgrid;

    private int length;
    @FXML
    private CheckBox upperCasebtn;
    @FXML
    private CheckBox numbtn;
    @FXML
    private CheckBox specialcharbtn;
    @FXML
    private CheckBox startWithLetterbtn;
    @FXML
    private CheckBox Unique;
    @FXML
    private Button generatebtn;




    private passwordCriteria criteria = new passwordCriteria();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> passwordLength = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20,1);
        passwordLength.setValue(1);
        mySpinner.setValueFactory(passwordLength);
        mySpinner.setEditable(false);

        //Acquire intital value which should be 1.
        length = mySpinner.getValue();



        //Update value every time there is a button press for the spinner
        mySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            length = newValue;
            criteria.setLength(length);
        });


    }








    @FXML
    private void handleUppercase(ActionEvent event) {
        criteria.setIsUpper(upperCasebtn.isSelected());
    }
    @FXML
    private void handlenum(ActionEvent event) {
        criteria.setIncludeNumbers(numbtn.isSelected());
    }
    @FXML
    private void handleSpecialChar(ActionEvent event) {
        criteria.setIncludeSpecial(specialcharbtn.isSelected());
    }
    @FXML
    private void handleStartWithLetter(ActionEvent event) {
        criteria.setStartWithLetter(startWithLetterbtn.isSelected());
    }
    @FXML
    private void handleDuplicate(ActionEvent event) {
        criteria.setHasDuplicates(Unique.isSelected());
    }


    @FXML
    private void handlegenerate(ActionEvent event) {
        System.out.println("Generate button pressed.");
        PasswordGenerator pg = new PasswordGenerator();
        String generatedPassword = pg.generatePassword(criteria);
        System.out.println("Example password => " + generatedPassword);
        for (Node node : passgrid.getChildren()) {
            if (node instanceof Label) {
                generatedPassword = pg.generatePassword(criteria);
                System.out.println("Password created => " + generatedPassword);
                ((Label) node).setText(generatedPassword);
            }
        }
    }
}
