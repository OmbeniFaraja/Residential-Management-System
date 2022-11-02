/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static residentialmanagement.tenant.tenantStage;

/**
 *
 * @author omben
 */
public class complains extends Application {
    
    static Stage  complainsStage = new Stage();
   
    @Override
    public void start(Stage complainsStage) {
           Label email_lbl = new Label("Email");
           Label hse_lbl = new Label("House Number");
           Label complaint_lbl = new Label("What is your issue?");
           TextField email_txt = new TextField();
           TextField hse_txt = new TextField();
           TextArea complaint_txt = new TextArea();
           
           Button submit_btn = new Button("Submit");
           submit_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           submit_btn.setCursor(Cursor.HAND);
           Button back_btn = new Button("BACK");
           back_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           back_btn.setCursor(Cursor.HAND);
           
           GridPane gridPane = new GridPane();
           gridPane.setMinSize(600,400);
           gridPane.setVgap(10);
           gridPane.setHgap(10);
           gridPane.setAlignment(Pos.CENTER);
           
           gridPane.add(email_lbl, 1,1);
           gridPane.add(email_txt, 2,1);
           gridPane.add(hse_lbl, 1, 2);
           gridPane.add(hse_txt, 2,2);
           gridPane.add(complaint_lbl, 1,3);
           gridPane.add(complaint_txt, 2,3);
           gridPane.add(submit_btn, 1,4);
           gridPane.add(back_btn, 2,4);
           
        complainsStage.setTitle("COMPLAINS PAGE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        complainsStage.setScene(my_scene);  
       
        complainsStage.show();
        
        back_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    tenant a = new tenant();
                    a.start(tenantStage);
                    
                    complainsStage.close();
                }
               }));
           
         submit_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
           
             String email = email_txt.getText();
             String hseNbr = hse_txt.getText();
             String complaint = complaint_txt.getText();
             
             
             try
             {
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/residential_management_system","root","kipese@!!!");
               
                Statement st= con.createStatement();                
               
                String query = "INSERT INTO `complaint` (`Email`,`Complaint_description`,`House_nbr`) VALUES ('"+email+"','"+complaint+"','"+hseNbr+"'); ";
                st.executeUpdate(query);
               

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Complaint Sent Successful");
                    al.show();
                   
                    email_txt.setText("");
                    hse_txt.setText("");
                    complaint_txt.setText("");

                con.close();
             
             }
            catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
            {
               
            }
         }
        }));

                   
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
