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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static residentialmanagement.admin.adminStage;
import static residentialmanagement.residentialmanagement.myStage;

/**
 *
 * @author omben
 */
public class adminlogin extends Application {
    
    static Stage  adminloginStage = new Stage();
   
    @Override
    public void start(Stage adminloginStage) {
           Label email_lbl = new Label("Email");
           Label pass_lbl = new Label("Password");
           TextField email_txt = new TextField();
           PasswordField pass_txt = new PasswordField();
           Button login_btn = new Button("Login");
           login_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           login_btn.setCursor(Cursor.HAND);
           
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
           gridPane.add(pass_lbl, 1, 2);
           gridPane.add(pass_txt, 2,2);
           gridPane.add(login_btn, 1,3);
           gridPane.add(back_btn, 2,3);
           
        adminloginStage.setTitle("ADMIN LOGIN");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        adminloginStage.setScene(my_scene);  
       
        adminloginStage.show();
        
             back_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    residentialmanagement a = new residentialmanagement();
                    a.start(myStage);
                    
                    adminloginStage.close();
                }
               }));
        
           
           login_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
               
         @Override
         public void handle(MouseEvent event) {
           
             String Email = email_txt.getText();
             String password = pass_txt.getText();
             
             
             
             
       try
             {
                 //Step One - Register the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                //Step Two - Creating the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/residential_management_system","root","kipese@!!!");
               
                //Step Three - Create the statement object
                Statement st= con.createStatement();                
               
                //Step Four - Execute your queries
                String query = "SELECT * FROM residential_management_system.admin Where Email = '"+Email+"' AND password = '"+password+"' ";
                ResultSet rs = st.executeQuery(query);
               
                if(rs.next())
                {
                    //You can replace this code with ANY code to be executed after a successfull login
//                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
  //                  al.setContentText("Successful Login");
    //                al.show();
                    
                    admin a = new admin();
                    a.start(adminStage);
                    //Home h = new Home();
                    //h.start(Home.homeStage);
                    
                    adminloginStage.close();
                }
               
                else
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Invalid Credentials");
                    al.show();
               
                }
               
                //Step five - Closing the connection
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

