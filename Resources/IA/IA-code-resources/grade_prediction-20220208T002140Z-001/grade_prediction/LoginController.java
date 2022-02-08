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

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    public Button btnBeginTargeting;
    @FXML
    public Button submit;
    @FXML
    private Label usernameText;
    @FXML
    private Label passwordText;
    Stage appStage;
    Parent root;

    @FXML
    private void buttonHandler1(ActionEvent event) throws Exception { // this switchs scene not stage

        appStage = (Stage) btnBeginTargeting.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void buttonHandler(ActionEvent event) throws Exception {

        //accounts.txt store the objejct "login details" each element in login details looks like "Teacher, username, password, id"
        try {
            ArrayList<String> LoginDetails = new ArrayList<String>();
            try {

                FileInputStream fi = new FileInputStream("Accounts.txt");

                ObjectInputStream oi = new ObjectInputStream(fi);

                // Read objects
                LoginDetails = (ArrayList<String>) oi.readObject();

                oi.close();

                fi.close();

            } catch (FileNotFoundException e) { //https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
                e.getLocalizedMessage();

            } catch (IOException e) {
                e.getLocalizedMessage();

            } catch (ClassNotFoundException e) {
                e.getLocalizedMessage();

            }
            //find the correct index that correspond to the username
            boolean found = false;
            String delims = "[,]";
            String temp = null;
            String[] tokens = null;
            for (String s : LoginDetails) {

                String[] token = s.split(delims);
                if (token[1].equals(username.getText())) {
                    tokens = token;
                    found = true;
                    break;
                }

            }

            if (!found) {
                System.out.println("username not found");
                usernameText.setText("Username Not Found!");
                passwordText.setText("");
                return;
            }

            if (password.getText().compareToIgnoreCase(tokens[2]) != 0) {
                System.out.println("wrong combination please enter again");
                passwordText.setText("Wroung U-P Combination!");
                usernameText.setText("");
                return;
            }
            passwordText.setText("");
            usernameText.setText("");
            
            
            if (tokens[0].compareToIgnoreCase("Teacher") == 0) {
                int id = Integer.parseInt(tokens[3]);
                
                Teacher h = TeacherManager.findTeacher(id);
                h.setPassword(tokens[2]);
                h.setUsername(tokens[1]);
                
                GRADE_PREDICTION.primaryTeacher = h;
                GRADE_PREDICTION.primaryStudent = null;
                
                System.out.println(GRADE_PREDICTION.primaryTeacher);
                
                //Teacher Account Switches to Teacher Page --> Search.fxml
                appStage = (Stage) submit.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Search.fxml"));
                Scene scene = new Scene(root);
                appStage.setScene(scene);
                appStage.show();
                return;
            }
            if (tokens[0].compareToIgnoreCase("Student") == 0) {
                int id = Integer.parseInt(tokens[3]);
                
                Student h = StudentManager.findStudent(id);
                h.setPassword(tokens[2]);
                h.setUsername(tokens[1]);
                
                GRADE_PREDICTION.primaryTeacher = null;
                GRADE_PREDICTION.primaryStudent = h;
                
                System.out.println(GRADE_PREDICTION.primaryStudent);
                
                //Student Account Switches to Student Page --> StudentPage.fxml
                appStage = (Stage) submit.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                Scene scene = new Scene(root);
                appStage.setScene(scene);
                appStage.show();

            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            return;
        }
        //at login, find the file titled username.txt
        //check to see if the password is correct
        //if the password is correct, then load the object ,teacher of student depending on the first item, into a new object using the .load() function and the ID also in the file
        //set theGRADE_PREDICTION.primaryTeacher or GRADE_PREDICTION.primaryStudent to the loaded object so that spefic teacher object can be accessed throughout the entire useof the system.
        //done

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameText.setText("");
        passwordText.setText("");
    }

}
