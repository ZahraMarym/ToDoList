/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.todolist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class MainSceneController implements Initializable {
    @FXML
    private Button BtnToDoList;
    @FXML 
    private BorderPane BorderPane1;
    @FXML
    private Button BtnSearch;
    @FXML
    private Button BtnUpdate;
    @FXML
    private Button BtnExit;
    private Label LabelHome;
    @FXML
    private Button BtnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ToDoList(MouseEvent event) {
    }

    

    @FXML
    private void Exit(MouseEvent event) {
        System.exit(0);
    }
    private void loadScene(String s) throws IOException{
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(s+".fxml"));
        BorderPane1.setCenter(root);
    }

    @FXML
    private void AddRemove(MouseEvent event) throws IOException {
        loadScene("AddRemove");
    }
}
