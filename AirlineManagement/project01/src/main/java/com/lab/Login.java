package com.lab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {
    private TextField tfusername;
    private PasswordField tfpassword;
    
    @Override
    public void start(Stage primaryStage) {
        Label lblusername = new Label("Username:");
        tfusername = new TextField();
        
        Label lblpassword = new Label("Password:");
        tfpassword = new PasswordField();
        
        Button reset = new Button("Reset");
        Button submit = new Button("Submit");
        Button close = new Button("Close");
        
        HBox buttonBox = new HBox(10, reset, submit, close);
        buttonBox.setAlignment(Pos.CENTER);
        
        VBox layout = new VBox(10, lblusername, tfusername, lblpassword, tfpassword, buttonBox);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20; -fx-background-color: white;");
        
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.show();
        
        submit.setOnAction(e -> handleLogin());
        reset.setOnAction(e -> {
            tfusername.clear();
            tfpassword.clear();
        });
        close.setOnAction(e -> primaryStage.close());
    }
    
    private void handleLogin() {
        String username = tfusername.getText();
        String password = tfpassword.getText();
        
        if (username.equals("admin") && password.equals("password")) {
            showAlert(Alert.AlertType.INFORMATION, "Login successful!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Invalid Username or Password");
        }
    }
    
    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

