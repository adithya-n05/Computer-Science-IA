/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class CreateClassController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tf;
    @FXML
    private Button submit;
    @FXML
    private CheckBox cb;
    Stage appStage;
    Parent root;

    @FXML
    private void buttonHandler1(ActionEvent event) throws Exception {
        if (tf.getText().length() < 1 ) {
            
            return;
        }
        char[] ttt = (tf.getText()).toLowerCase().toCharArray();
        char[] alphabet = {'a', 'b', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'n', 'm','1','2','3','4','5','6','7','8','9','0',' '};
        int counter = 0;
        boolean found = false;
        for (char t : ttt) {
            for (char b : alphabet) {
                if (b == t) {

                    
                    counter++;

                }

            }

        }
        if (counter != ttt.length) {
            
            return;

        }
        int id;
        
        
        do{
            double h = Math.random() * 89999 + 10000;
            id = (int) h;
        }while(GRADE_PREDICTION.getId().contains(id));
        
        GRADE_PREDICTION.setId(id);

        Class temp = new Class();
        temp = ClassManager.createClass(GRADE_PREDICTION.primaryTeacher, new Subject(tf.getText(), cb.isPressed()), id);
        TeacherManager.save();

        appStage = (Stage) submit.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
