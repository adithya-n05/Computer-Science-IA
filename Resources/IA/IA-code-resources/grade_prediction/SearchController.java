/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.*;
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
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author sameer
 */
public class SearchController implements Initializable {

    /**
     * Initializes the controller class.
     *
     *
     */
    @FXML
    private ListView classListView;
    @FXML
    private Button submit;
    @FXML
    private LineChart<String, Double> lc;
    @FXML
    private Button newStudent;
    @FXML
    private MenuButton mb;
    @FXML
    private Label one;
    @FXML
    private Label two;
    @FXML
    private Label three;
    @FXML
    private Label four;
    @FXML
    private Label five;
    @FXML
    private Label six;
    @FXML
    private Label seven;
    @FXML
    private Label NNpredict;
    @FXML
    private Label gradientPredict;
    @FXML
    private Label composite;
    @FXML
    private Label LinRegPredict;
    @FXML
    private Label TeacherAverage;
    @FXML
    private Label classMean;
    @FXML
    private Label classMedian;
    @FXML
    private Button spreadsheet;
    @FXML
    private Button editGrade;
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
    ArrayList<TextField> gradess = new ArrayList<TextField>();
    public static Class currentClass = null;
    public static ArrayList<Student> ss = new ArrayList<Student>();
    public Student currentStudent = null;
    boolean editable = false;

    Stage appStage;
    Parent root;

    @FXML
    private Button back;

    @FXML
    private void back(ActionEvent event) throws Exception { // this switchs scene not stage

        GRADE_PREDICTION.primaryStudent = null;
        GRADE_PREDICTION.primaryTeacher = null;
        appStage = (Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void createClassButtonHandler(ActionEvent event) throws Exception { // this switchs scene not stage

        appStage = (Stage) submit.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CreateClass.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void addStudentButtonHandler(ActionEvent event) throws Exception { // this switchs scene not stage

        if (currentClass != null) {
            AddStudentController.tempClass = currentClass;
            appStage = (Stage) submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
            Scene scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();

        }
    }

    @FXML
    private void allowEditGrades(ActionEvent event) throws Exception {
// this switchs scene not stage
        if (editable == false) {
            for (TextField tf : gradess) {

                tf.setDisable(false);
                editGrade.setText("Done");
            }
            editable = true;
        } else {
            ArrayList<String> texts = new ArrayList<String>();
            for (TextField tf : gradess) {

                texts.add(tf.getText());
            }

            try {

                boolean decider = true;
                //this is validaion
                for (int i = 0; i < texts.size(); i++) {
                    if (texts.get(i).equalsIgnoreCase("")) {

                        continue;
                    }
                    try {
                        Double temp = Double.parseDouble(texts.get(i));
                    } catch (Exception e) {
                        gradess.get(i).setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                    }
                    Double grade = Double.parseDouble(texts.get(i));
                    if ((grade < 1.0 || grade > 7.9)) {

                        gradess.get(i).setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                        decider = false;
                    }
                }
                //validation ends here
                if (decider) {
                    for (int i = 0; i < gradess.size(); i++) {

                        if (texts.get(i).equals("")) {
                            GRADE_PREDICTION.primaryTeacher.editGrade(currentStudent.getID(), 0.0, i, currentClass);

                        } else {
                            Double grade = Double.parseDouble(gradess.get(i).getText());
                            GRADE_PREDICTION.primaryTeacher.editGrade(currentStudent.getID(), grade, i, currentClass);
                        }

                        gradess.get(i).setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 13));

                    }
                    for (TextField tf : gradess) {

                        tf.setDisable(true);

                    }
                    editable = false;

                    updateTrend();
                    editGrade.setText("Edit");
                }

            } catch (Exception e) {  //System.out.println(texts); e.printStackTrace();

            }

        }
    }

    private void updateTrend() {

        if (currentClass == null || currentStudent == null) {
            return;
        }
        //get the grades of the student.
        lc.getData().clear();

        ArrayList<Double> grades = new ArrayList<Double>();
        grades = currentStudent.getGrades(currentClass);

        try {

            String[] labels = {"11Q1-1", "11Q1-2", "11Q2-1", "11S1", "11Q3-1", "11Q3-2", "11Q4-1", "11S2", 
                "12Q1-1", "12Q1-2", "12Q2-1", "12S1", "Mock", "I.A"};
            lc.setTitle(currentStudent.getFirstname() + "s Trend");
            XYChart.Series series = new XYChart.Series();
            series.setName("Trend");
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

            //adding another series to plot the trend
            XYChart.Series trend = new XYChart.Series();
            trend.setName("L.O.B.F"); // this is just my own (hand coded) linear regression model. 
            //See LinReg.java or the @func predicted in Teacher.java.

            XYChart.Series trend1 = new XYChart.Series();
            trend1.setName("G_pred");//this is my own custom algorithm... it predicted the next gradient. 
            //It only account for the most recent three data sets
            ArrayList<Double> pgs = new ArrayList<Double>();

            pgs = GRADE_PREDICTION.primaryTeacher.predictGrade(currentStudent.getID(), currentClass, grades);

            ArrayList<Double> lobf = currentStudent.getTrend(currentClass);

            trend.getData().add(temp);
            trend1.getData().add(temp2);

            trend.getData().add(new XYChart.Data("p", pgs.get(1)));

            double trend1grade = Math.round(currentStudent.gradient + grades.get(indexs.get(indexs.size() - 1))*100.0)/100.0;
            
            if (trend1grade > currentStudent.max(currentStudent.getGrades(currentClass))) {
                trend1grade = currentStudent.max(currentStudent.getGrades(currentClass));
            }
            if (trend1grade < 1.0) {
                trend1grade = 1.0;
            }
            trend1.getData().add(new XYChart.Data("p", trend1grade));

            lc.getData().add(trend);
            lc.getData().add(trend1);
            
            
            gradientPredict.setText(trend1grade+"");

            ArrayList<Double> probs = GRADE_PREDICTION.primaryTeacher.probabilityPredict(currentStudent.getID(), currentClass);

            one.setText(probs.get(0) + "");
            two.setText(probs.get(1) + "");
            three.setText(probs.get(2) + "");
            four.setText(probs.get(3) + "");
            five.setText(probs.get(4) + "");
            six.setText(probs.get(5) + "");
            seven.setText(probs.get(6) + "");

            NNpredict.setText(pgs.get(0) + "");
            LinRegPredict.setText(pgs.get(1) + "");
            TeacherAverage.setText(pgs.get(2) + "");
            pgs.add(trend1grade);
            System.out.println(pgs + "hhhhh");System.out.println(probs+"kkkkkkk");
            GRADE_PREDICTION.primaryTeacher.predictCompositeGrade(probs,pgs , currentClass, currentStudent);
            
            composite.setText(Double.toString(currentStudent.getPredicteds(currentClass)));

        } catch (Exception e) {
            one.setText(0 + "");
            two.setText(0 + "");
            three.setText(0 + "");
            four.setText(0 + "");
            five.setText(0 + "");
            six.setText(0 + "");
            seven.setText(0 + "");

            NNpredict.setText(0 + "");
            LinRegPredict.setText(0 + "");
            TeacherAverage.setText(0 + "");
            
            composite.setText(0+"");
            gradientPredict.setText(0+"");
            //e.printStackTrace();

        }

        classMean.setText("");

        classMedian.setText(/*currentClass.classMedian() + */ "");

        //display the grades
        for (int i = 0; i < grades.size(); i++) {
            gradess.get(i).setDisable(true);

            gradess.get(i).setText(currentStudent.getGrades(currentClass).get(i) + "");
            if (currentStudent.getGrades(currentClass).get(i) == 0.0) {
                gradess.get(i).setText("");
            }

        }

    }

    @FXML
    private void removeClass(ActionEvent event) {
        try {
            currentStudent = null;
            one.setText(0 + "");
            two.setText(0 + "");
            three.setText(0 + "");
            four.setText(0 + "");
            five.setText(0 + "");
            six.setText(0 + "");
            seven.setText(0 + "");

            NNpredict.setText(0 + "");
            LinRegPredict.setText(0 + "");
            TeacherAverage.setText(0 + "");
            composite.setText(0+"");
            gradientPredict.setText(0+"");
            lc.getData().clear();
            GRADE_PREDICTION.primaryTeacher.removeClass(currentClass.getID());
            currentClass = null;
            init();
        } catch (Exception e) {

        }

    }

    @FXML
    private void removeStudent(ActionEvent event) {
        try {
            one.setText(0 + "");
            two.setText(0 + "");
            three.setText(0 + "");
            four.setText(0 + "");
            five.setText(0 + "");
            six.setText(0 + "");
            seven.setText(0 + "");

            NNpredict.setText(0 + "");
            LinRegPredict.setText(0 + "");
            TeacherAverage.setText(0 + "");
            composite.setText(0+"");
            gradientPredict.setText(0+"");
            lc.getData().clear();
            currentClass.removeStudent(currentStudent.getID());
            currentStudent = null;
            init();
            ArrayList<Student> items = new ArrayList<Student>();
            mb.getItems().clear();
            for (Student s : currentClass.getClassStudents()) {
                items.add(s);
                MenuItem mi = new MenuItem(s.getFirstname() + " " + s.getSurname());
                mi.setOnAction((eventTemp) -> {
                    currentStudent = s;
                    editGrade.setDisable(false);
                    System.out.println(currentStudent);
                    mb.setText(s.getFirstname());
                    updateTrend();

                });
                mb.getItems().add(mi);
            }
            ss = items; //universally store the array for easy access
        } catch (Exception e) {

        }

    }

    @FXML
    private void createSpreadsheet(ActionEvent event) throws Exception {
        if (currentClass == null || currentStudent == null) {
            return;
        }
        everything();
        classAndStudent(currentClass, currentStudent);
        classSpread(currentClass);
        student(currentStudent);

    }

    public void everything() {//all classes, all students, 
        String content = "";
        for (Class c : GRADE_PREDICTION.primaryTeacher.getClasses()) {
            content += "" + c.getClassSubject().getSubjectName() + "\n";
            for (Student s : c.getClassStudents()) {
                content += s.getFirstname() + s.getSurname();
                ArrayList<Double> studentGrades = s.getGrades(c);

                for (Double g : studentGrades) {
                    content += "," + g;
                }
                content += "\n";

            }
        }
        try {
            FileWriter newFile = new FileWriter(new File("everything.csv"));
            BufferedWriter bf = new BufferedWriter(newFile);
            bf.write(content);
            bf.close();
        } catch (Exception s) {

        }

    }

    public void classAndStudent(Class c, Student s) {//specific class spefici student

        String content = "";
        content += s.getFirstname() + s.getSurname();
        ArrayList<Double> studentGrades = s.getGrades(c);

        for (Double g : studentGrades) {
            content += "," + g;
        }
        content += "\n";

        try {
            FileWriter newFile = new FileWriter(new File(s.getFirstname() + ".csv"));
            BufferedWriter bf = new BufferedWriter(newFile);
            bf.write(content);
            bf.close();
        } catch (Exception e) {

        }
    }

    public void classSpread(Class c) {//single class, all students
        String content = "";

        content += "" + c.getClassSubject().getSubjectName() + "\n";
        for (Student s : c.getClassStudents()) {
            content += s.getFirstname() + s.getSurname();
            ArrayList<Double> studentGrades = s.getGrades(c);

            for (Double g : studentGrades) {
                content += "," + g;
            }
            content += "\n";

        }

        try {
            FileWriter newFile = new FileWriter(new File("Grades.csv"));
            BufferedWriter bf = new BufferedWriter(newFile);
            bf.write(content);
            bf.close();
        } catch (Exception s) {

        }
    }

    public void student(Student s) {// single student, all classes.
        String content = "";
        ArrayList<Class> cs = s.getClasses();
        content += s.getFirstname() + s.getSurname() + "\n";

        for (Class c : cs) {
            content += "" + c.getClassSubject().getSubjectName();

            ArrayList<Double> studentGrades = s.getGrades(c);

            for (Double g : studentGrades) {
                content += "," + g;
            }
            content += "\n";

        }

        try {
            FileWriter newFile = new FileWriter(new File("student.csv"));
            BufferedWriter bf = new BufferedWriter(newFile);
            bf.write(content);
            bf.close();
        } catch (Exception e) {

        }
    }

    public void init() {
        editGrade.setDisable(true);

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

        for (TextField tf : gradess) {
            tf.setText(null);
            tf.setDisable(true);
        }
        editable = false;

        ObservableList<Class> items = FXCollections.observableArrayList();
        for (Class c : GRADE_PREDICTION.primaryTeacher.getClasses()) {
            items.add(c);

        }
        classListView.setItems(items);

        ListView list = classListView;
        lc.getData().clear();

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
                //Check wich list index is selected then set txtContent value for that index 
                list.getItems().forEach((c) -> {
                    if (list.getSelectionModel().getSelectedIndex() == list.getItems().indexOf(c)) {
                        lc.getData().clear();

                        currentClass = (Class) c;

                        for (TextField tf : gradess) {

                            tf.setDisable(true);
                            tf.setText("");
                        }
                        editable = true;
                        editGrade.setDisable(true);
                        ArrayList<Student> items = new ArrayList<Student>();
                        mb.getItems().clear();
                        for (Student s : currentClass.getClassStudents()) {
                            items.add(s);
                            MenuItem mi = new MenuItem(s.getFirstname() + " " + s.getSurname());
                            mi.setOnAction((event) -> {
                                currentStudent = s;
                                editGrade.setDisable(false);
                                System.out.println(currentStudent);
                                mb.setText(s.getFirstname());
                                updateTrend();

                            });
                            mb.getItems().add(mi);
                        }
                        ss = items; //universally store the array for easy access

                        System.out.println(currentClass.getID());
                    }
                });

            }

        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { //https://gist.github.com/Zookey/2759649
        currentClass = null;
        currentStudent = null;
        init();

    }

}
