/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.todolist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class AddController implements Initializable{
    MyList mylist = new MyList();
    Alert alert = new Alert(AlertType.INFORMATION);
    
    @FXML
    private Label LAsub;
    @FXML
    private Label LAloc;
    @FXML
    private Label LAdate;
    @FXML
    private Label LAtime;
    @FXML
    private Label LAdes;
    @FXML
    private TextField TFAsub;
    @FXML
    private TextField TFAloc;
    @FXML
    private TextField TFAdate;
    @FXML
    private TextField TFAtime;
    @FXML
    private TextArea TAAdes;
    @FXML
    private Button AddB1;
    @FXML
    private Button RemoveBtn;
    @FXML
    private ListView<String> ListOfTask;
    @FXML
    private Label blah;
    @FXML
    private TextField TFSearch;
    @FXML
    private Button SearchBTN;
    @FXML
    private Button BtnUpdate;
    String Z = "";
    static String s;
    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        // Read data from file and set it in the ListView
        ObservableList<String> dataList = readDataFromFile("C:\\Users\\Zahra Maryam\\Desktop\\ToDoList.txt");
        ListOfTask.setItems(dataList);

    }    

    @FXML
    private void HandleAddAction(ActionEvent event) throws FileNotFoundException, IOException{     
        String subject = TFAsub.getText();
    String location = TFAloc.getText(); 
    String date = TFAdate.getText(); 
    String time = TFAtime.getText();
    String Description = TAAdes.getText();    
    ArrayList list = new ArrayList();
    list.add(date);
        list.add(time);
        list.add(subject);
        list.add(Description);
        list.add(location);
        s = list.toString();
        ListOfTask.getItems().add(s);
        Z = Z + s +"\n";
        TFAloc.setText("");
        TFAsub.setText("");
        TFAdate.setText(""); 
        TFAtime.setText("");
        TAAdes.setText(""); 
    }
    @FXML
    private void HandleRemoveAction(ActionEvent e) throws IOException{
         int selectedID = ListOfTask.getSelectionModel().getSelectedIndex();
         ListOfTask.getItems().remove(selectedID);
    }
    @FXML
     private void HandleSearchAction(ActionEvent event) {
         String search = TFSearch.getText(); 
         if(Z.contains(search)){
             alert.setAlertType(AlertType.INFORMATION);
             alert.setContentText("Presnet in your List");   
             System.out.println(Z+"Found");
         }
         else{
             System.out.println(Z+"Not Found");

         }
        }
     
     @FXML
     private void HandleUpdateAction(ActionEvent event) throws FileNotFoundException, IOException {
        
    int selectedID = ListOfTask.getSelectionModel().getSelectedIndex();
    ListOfTask.getItems().remove(selectedID);
    String subject = TFAsub.getText();
    String location = TFAloc.getText(); 
    String date = TFAdate.getText(); 
    String time = TFAtime.getText();
    String Description = TAAdes.getText();    
    ArrayList list = new ArrayList();
    list.add(date);
        list.add(time);
        list.add(subject);
        list.add(Description);
        list.add(location);
        String c = list.toString();;
        Z = Z +c+"\n";
        ListOfTask.getItems().add(selectedID, c);
        TFAloc.setText("");
        TFAsub.setText("");
        TFAdate.setText(""); 
        TFAtime.setText("");
        TAAdes.setText(""); 
          
     }

     @FXML
     private void HandleSaveAction(ActionEvent event) throws IOException {
         FileWriter writer = new FileWriter("C:\\Users\\Zahra Maryam\\Desktop\\ToDoList.txt");
         writer.write(Z+"\n");
         writer.close(); 
         PrintStream console = System.out;
        PrintStream fileOut = new PrintStream("./ToDoList.txt");
          System.setOut(fileOut);
          System.setOut(console);
          System.out.println(Z);
          
        
     }
    private ObservableList<String> readDataFromFile(String fileName) {
        ObservableList<String> dataList = FXCollections.observableArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}

