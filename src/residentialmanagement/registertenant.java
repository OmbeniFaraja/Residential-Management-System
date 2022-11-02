/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *138367
 *138458
 * @author omben
 */

public class registertenant extends Application {
    
    static Stage  registertenantStage = new Stage();
   
    @Override
    public void start(Stage registertenantStage) {
        Label fname_lbl = new Label("Firstname: ");
        Label lname_lbl = new Label("Surname: ");
        Label email_lbl = new Label("Email: ");
        Label tel_lbl = new Label("Phone Number: ");
        Label pass_lbl = new Label("Password: ");
        Label hse_lbl = new Label("House Nbr: ");
        
        TextField fname_txt = new TextField();
        TextField lname_txt = new TextField();
        TextField email_txt = new TextField();
        TextField tel_txt = new TextField();
        PasswordField pass_txt = new PasswordField();
        TextField hse_txt = new TextField();
        
        Button register_btn = new Button("Register");
        register_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        register_btn.setCursor(Cursor.HAND);
        Button back_btn = new Button("BACK");
        back_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        back_btn.setCursor(Cursor.HAND);
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
       
        gridPane.add(fname_lbl, 1,1);
        gridPane.add(fname_txt, 2,1);
        gridPane.add(lname_lbl, 1,2);
        gridPane.add(lname_txt, 2,2);
        gridPane.add(email_lbl, 1,3);
        gridPane.add(email_txt, 2,3);
        gridPane.add(tel_lbl, 1,4);
        gridPane.add(tel_txt, 2,4);
        gridPane.add(hse_lbl, 1,5);
        gridPane.add(hse_txt, 2,5);
        gridPane.add(pass_lbl, 1,6);
        gridPane.add(pass_txt, 2,6);
        gridPane.add(register_btn, 1,7);
        gridPane.add(back_btn, 2,7);
       
       
        registertenantStage.setTitle("REGISTER TENANT");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        registertenantStage.setScene(my_scene);  
       
        registertenantStage.show();
        
        back_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    admin a = new admin();
                    a.start(adminStage);
                    
                    registertenantStage.close();
                }
               }));
       
       
        register_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         public void handle(MouseEvent event) {
             
             String firstname = fname_txt.getText();
             String lastname = lname_txt.getText();
             String email = email_txt.getText();
             String telephone = tel_txt.getText();
             String hseNbr = hse_txt.getText();
             String password = pass_txt.getText();
             
             
             try
             {
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/residential_management_system","root","kipese@!!!");
               
                Statement st= con.createStatement();                
               
                String query = "INSERT INTO `tenant` (`First_name`, `Last_name`, `Email`, `Phone_number`, `Password`, `House_nbr`) VALUES ('"+firstname+"', '"+lastname+"', '"+email+"', '"+telephone+"', '"+password+"', '"+hseNbr+"'); ";
                st.executeUpdate(query);
               

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Registration Successful");
                    al.show();
                   
                    fname_txt.setText("");
                    lname_txt.setText("");
                    email_txt.setText("");
                    pass_txt.setText("");
                    tel_txt.setText("");
                    hse_txt.setText("");
                    email_txt.setText("");

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