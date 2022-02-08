/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import static grade_prediction.AddStudentController.currentStudent;
import static grade_prediction.AddStudentController.tempClass;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class ViewClassInfoController implements Initializable {

    @FXML
    private Button yes;
    @FXML
    private Button no;
    @FXML 
    private Label prompt;
    
    Stage appStage;
    Parent root;
    static Student s;
    static Class c;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void ButtonHandlerYes(ActionEvent event) throws Exception { 

        //if the Yes button is selected, the variable "transfer" in the AddStudent page is set to true
        //the student's old grades will be loaded back into the class
        AddStudentController.transfer = true;
        Stage stage = (Stage) yes.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void ButtonHandlerNo(ActionEvent event) throws Exception { 

        //if the Yes button is selected, the variable "transfer" in the AddStudent page is set to false
        //the students grades will not be retained
        AddStudentController.transfer = false;
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String text = "The student " + s.getFirstname() + " already has record of attending this class. "
                + "\nWould you like to load his previously attained grades?";
        prompt.setText(text);
    }    
    
}
