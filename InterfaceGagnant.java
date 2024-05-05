package tournoidetennis;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;


import javafx.stage.Stage;
public class InterfaceGagnant extends Application {
	           int scoreJoueur1=0;
	           
	           int scoreJoueur2=0;
	   
	    	@Override
	    	public void start(Stage primaryStage) {
	    		
	        	
	    		
	    		primaryStage.setTitle("Score Joueur");
	    	        Text resultText=new Text();
	    	        Text pointsJoueur1=new Text("0");
	    	        Text pointsJoueur2=new Text("0");
	    	        resultText.setFont(Font.font("Arial", FontWeight.BOLD, 20));  	    
	    	        resultText.setFill(Color.DARKBLUE);
	    	        Button ButtonJoueur1=new Button("Joueur1");
	    	        ButtonJoueur1.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white ;");
	    	        
	    	        Button ButtonJoueur2=new Button("Joueur2");
	    	        ButtonJoueur2.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white ;");
	    	        ButtonJoueur1.setOnAction(e ->{
	    	        	scoreJoueur1++;
	    	        	changerScore(pointsJoueur1,scoreJoueur1);
	    	        	updateResultat(resultText,ButtonJoueur1,ButtonJoueur2);
	    	        });
	    	        ButtonJoueur2.setOnAction(e ->{
	    	        	scoreJoueur2++;
	    	        	changerScore(pointsJoueur2,scoreJoueur2);
	    	        	updateResultat(resultText,ButtonJoueur1,ButtonJoueur2);
	    	        });
	    	        
	    	        HBox scoreBox=new HBox(30,ButtonJoueur1,pointsJoueur1,ButtonJoueur2,pointsJoueur2);
	    	        scoreBox.setPadding(new Insets((30)));
	    	        
	    	        VBox root =new VBox(30,scoreBox,resultText);
	    	        
	    	        root.setPadding(new Insets(30));
	    	        try {
	    	        Image backgroundImage = new Image("C:/Users/DELL/Desktop/tennis.jfif");

	    	        
	    	        BackgroundImage background = new BackgroundImage(
	    	                backgroundImage,
	    	                BackgroundRepeat.NO_REPEAT,
	    	                BackgroundRepeat.NO_REPEAT,
	    	                BackgroundPosition.DEFAULT,
	    	                BackgroundSize.DEFAULT);

	    	        
	    	        root.setBackground(new Background(background));
	    	        }catch(Exception e) {
	    	        	System.out.println("Error loading background");
	    	        }
	    	       
	    	        Scene scene=new Scene(root,400 ,300);
	    	        
	    	        primaryStage.setScene(scene); 
	    	        primaryStage.show();
	    	    }
	    	private void updateResultat(Text resultat, Button ButtonJoueur2, Button ButtonJoueur1) {
	    		if(scoreJoueur1>=4&& scoreJoueur1-scoreJoueur2>=2) {
	    			disableButtons(ButtonJoueur1,ButtonJoueur2);
	    			resultat.setText("le joueur1 gagne");
	    			
	    		}else if(scoreJoueur2>=4&& scoreJoueur2-scoreJoueur1>=2){
	    			disableButtons(ButtonJoueur1,ButtonJoueur2);
	    			resultat.setText("le joueur2 gagne");
	    			
	    		}
	    	}
	    	
	    	 void disableButtons(Button button1,Button button2) {
	    		button1.setDisable(true);
	    		button2.setDisable(true);
	    	}
	    	 void changerScore(Text t,int scoreJoueur) {
	    		 t.setText(" "+scoreJoueur);
	    	 }
	    	

	    	
	    
	 public static void main(String[] args) {
	        launch(args);
	    }
}
