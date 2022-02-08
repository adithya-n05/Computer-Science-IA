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
import java.util.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class CreateAccountController implements Initializable {

    /**
     * Initializes the controller class.
     *
     *
     */
    private ArrayList<String> LoginDetails = new ArrayList<String>();

    @FXML
    private MenuButton mb;
    @FXML
    private TextField fn;
    @FXML
    private TextField sn;
    @FXML
    private TextField s;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordConfirm;
    @FXML
    private MenuItem student;
    @FXML
    private MenuItem teacher;
    @FXML
    private Button submit;
    private String menuOption = null;
    Stage appStage;
    Parent root;
    @FXML
    private Button back;

    private boolean u(String username) throws Exception {
        for (String s : LoginDetails) {
            String delims = "[,]";
            String[] tokens = s.split(delims);
            if (tokens[1].equals(username)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void back(ActionEvent event) throws Exception { // this switchs scene not stage

        appStage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    public void saveUsername() {

        try {

            FileOutputStream f = new FileOutputStream("Accounts.txt");

            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(LoginDetails);

            o.close();

            f.close();

        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }

    public ArrayList<String> loadUsernames() {

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

        } finally {
            return LoginDetails;
        }

    }

    @FXML
    private void buttonHandler(ActionEvent event) throws Exception { //this creates a new account onc lick of the button
        //all validation
        //validate password
        Font font = Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 13);
        
        if(menuOption == null){
            return;
        }

        if (password.getText().length() < 1 || username.getText().length() < 1) {
            password.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
            username.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
            return;
        }
        password.setFont(font);
        passwordConfirm.setFont(font);
        username.setFont(font);
        fn.setFont(font);
        sn.setFont(font);
        if (!password.getText().equalsIgnoreCase(passwordConfirm.getText())) {
            password.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
            passwordConfirm.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
            return;
        }
        password.setFont(font);
        passwordConfirm.setFont(font);
        username.setFont(font);
        fn.setFont(font);
        sn.setFont(font);
        char[] ttt = (fn.getText() + sn.getText()).toLowerCase().toCharArray();
        char[] alphabet = {'a', 'b', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'n', 'm'};
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
            fn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
            sn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
            return;

        }
        password.setFont(font);
        passwordConfirm.setFont(font);
        username.setFont(font);
        fn.setFont(font);
        sn.setFont(font);

        loadUsernames();
        int id;
        
        do{
            double h = Math.random() * 89999 + 10000;
            id = (int) h;
        }while(GRADE_PREDICTION.getId().contains(id));
        
        GRADE_PREDICTION.setId(id);
        String fileContent = "";
        
        if (u(username.getText())) {
            System.out.println("username taken");
            return;
        }

        if (menuOption.equalsIgnoreCase("Teacher")) {
            System.out.println("Teacher");
            Teacher temp = TeacherManager.createTeacher(fn.getText(), sn.getText(), s.getText(), id);
            fileContent = "Teacher," + username.getText() + "," + password.getText() + "," + id;
            temp.setU(username.getText());
            temp.setP(password.getText());
            TeacherManager.save();

        } else if (menuOption.equalsIgnoreCase("Student")) {
            System.out.println("Student");
            Student temp = StudentManager.createStudent(fn.getText(), sn.getText(), s.getText(), id);

            temp.setU(username.getText());
            temp.setP(password.getText());
            fileContent = "Student," + username.getText() + "," + password.getText() + "," + id;
            StudentManager.save();

        }
        LoginDetails.add(fileContent);
        saveUsername();

        Stage appStage;
        Parent root;

        appStage = (Stage) submit.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        student.setOnAction(event -> {
            menuOption = "Student";
            mb.setText(menuOption);
        });

        teacher.setOnAction(event -> {
            menuOption = "Teacher";
            mb.setText(menuOption);
        });

    }

}
