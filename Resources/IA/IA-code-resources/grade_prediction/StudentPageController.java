/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import static grade_prediction.SearchController.currentClass;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class StudentPageController implements Initializable {

    @FXML
    private TextField aa;
    @FXML
    private TextField ab;
    @FXML
    private TextField ac;
    @FXML
    private TextField ad;
    @FXML
    private TextField ae;
    @FXML
    private TextField af;
    @FXML
    private TextField ag;
    @FXML
    private TextField ah;
    @FXML
    private TextField ai;
    @FXML
    private TextField aj;
    @FXML
    private TextField ak;
    @FXML
    private TextField al;
    @FXML
    private TextField am;
    @FXML
    private TextField an;
    @FXML
    private LineChart<String, Double> lc;
    Class currentClass = new Class();
    @FXML
    private MenuButton mb;
    @FXML
    private Button back;
    String menuOption = null;
    ArrayList<TextField> gradess = new ArrayList<TextField>();
    Stage appStage;
    Parent root;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void back(ActionEvent event) throws Exception { // this switchs scene not stage

        appStage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    private void updateS() {

        lc.getData().clear();
        ArrayList<Double> grades = new ArrayList<Double>();
        grades = GRADE_PREDICTION.primaryStudent.getGrades().get(currentClass);
        ;

        String[] labels = {"11Q1-1", "11Q1-2", "11Q2-1", "11S1", "11Q3-1", "11Q3-2", "11Q4-1", "11S2", "12Q1-1", "12Q1-2", "12Q2-1", "12S1", "Mock", "I.A"};
        lc.setTitle(GRADE_PREDICTION.primaryStudent.getFirstname() + "s Trend");
        XYChart.Series series = new XYChart.Series();
        series.setName("S Trend");
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        XYChart.Data temp = new XYChart.Data();
        XYChart.Data temp2 = null;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) != 0.0) {
                //skips all spaces that are null
                series.getData().add(new XYChart.Data(labels[i], grades.get(i)));
                XYChart.Data temps = new XYChart.Data(labels[i], grades.get(i));
                temp2 = new XYChart.Data(labels[i], grades.get(i));
                temp = temps;

                indexs.add(i);

            }
        }

        lc.getData().add(series);

        XYChart.Series trend = new XYChart.Series();
        trend.setName("predicted");

        XYChart.Series trend1 = new XYChart.Series();
        trend1.setName("predicted1");

        try {
            ArrayList<Double> pgs = new ArrayList<Double>();
            pgs = currentClass.getTeacher().predictGrade(GRADE_PREDICTION.primaryStudent.getID(), currentClass, grades);
            trend.getData().add(temp);
            trend.getData().add(new XYChart.Data("p", pgs.get(1)));
            lc.getData().add(trend);

            trend1.getData().add(temp2);
            double trend1grade = GRADE_PREDICTION.primaryStudent.gradient + grades.get(indexs.get(indexs.size() - 1));
            if (trend1grade > GRADE_PREDICTION.primaryStudent.max(GRADE_PREDICTION.primaryStudent.getGrades(currentClass))) {
                trend1grade = GRADE_PREDICTION.primaryStudent.max(GRADE_PREDICTION.primaryStudent.getGrades(currentClass));
            }
            if (trend1grade < 1.0) {
                trend1grade = 1.0;
            }
            trend1.getData().add(new XYChart.Data("p", trend1grade));
            lc.getData().add(trend1);
        } catch (Exception s) {

        }

        for (int i = 0; i < grades.size(); i++) {
            gradess.get(i).setDisable(true);

            gradess.get(i).setText(GRADE_PREDICTION.primaryStudent.getGrades(currentClass).get(i) + "");
            if (GRADE_PREDICTION.primaryStudent.getGrades(currentClass).get(i) == 0.0) {
                gradess.get(i).setText("");
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            gradess.clear();
            gradess.add(aa);
            gradess.add(ab);
            gradess.add(ac);
            gradess.add(ad);
            gradess.add(ae);
            gradess.add(af);
            gradess.add(ag);
            gradess.add(ah);
            gradess.add(ai);
            gradess.add(aj);
            gradess.add(ak);
            gradess.add(al);
            gradess.add(am);
            gradess.add(an);

            GRADE_PREDICTION.primaryStudent.getClasses().forEach((c) -> {
                MenuItem temp = new MenuItem(c.getClassSubject().getSubjectName());

                temp.setOnAction(event -> {
                    menuOption = c.getClassSubject().getSubjectName();
                    mb.setText(menuOption);
                    currentClass = c;
                    updateS();
                    //
                });
                mb.getItems().add(temp);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO
    }

}
