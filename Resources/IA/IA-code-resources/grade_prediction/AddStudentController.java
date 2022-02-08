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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class AddStudentController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    @FXML
    private TextField searchBar;
    @FXML
    private ListView lv;
    @FXML
    private Button submit;

    public static Student currentStudent = null;
    public static Class tempClass = null;

    Stage appStage;
    Parent root;

    static boolean transfer = false;

    @FXML
    private void ButtonHandler(ActionEvent event) throws Exception { // this switchs scene not stage

        if (tempClass.getClassStudents().contains(currentStudent) == false) {
            System.out.println(currentStudent.getGrades().keySet());

            currentStudent.getGrades().keySet().forEach(c -> {
                if (c.getID() == tempClass.getID()) { // if there are multiple classes... which one should we pick. problem to fix
                    try {
                        ViewClassInfoController.s = currentStudent;
                        ViewClassInfoController.c = tempClass;
                                
                        System.out.println("hello");
                        Stage newStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("ViewClassInfo.fxml"));
                        Scene scene = new Scene(root);
                        newStage.setScene(scene);
                        newStage.showAndWait();
                    } catch (Exception e) {
                        System.out.println("hi");
                        e.printStackTrace();
                    }

                }

            });

            if (transfer == false) {
                currentStudent.getGrades().remove(tempClass);
            }

            tempClass.addStudent(currentStudent);

            appStage = (Stage) submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Search.fxml"));
            Scene scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        searchBar.setOnKeyPressed(event -> {

            ObservableList<Student> items = FXCollections.observableArrayList();
            items.setAll(StudentManager.findStudents(searchBar.getText()));
            lv.setItems(items);

            ListView list = lv;

            list.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent me) {
                    //Check wich list index is selected then set txtContent value for that index 
                    list.getItems().forEach((c) -> {
                        if (list.getSelectionModel().getSelectedIndex() == list.getItems().indexOf(c)) {
                            currentStudent = (Student) c;

                        }
                    });

                }

            });

            lv.refresh();

        });
    }

}
