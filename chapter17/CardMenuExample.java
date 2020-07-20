
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.Font;

public class CardMenuExample extends Application
{     
    private int currentCard = 0; // to keep track of the cards
    private StackPane stack = new StackPane();  // to hold the cards
    
    @Override
    public void start(Stage stage)
    {
        // create a label for the first card (choosing the level)
        Label levelLabel = new Label("Choose your level");
        levelLabel.setFont(Font.font ("Verdana", 15));

        // create an HBox containing three dummy buttons for the first card (choosing the level)
        HBox levelButtons = new HBox(10);
        levelButtons.getChildren().addAll(new Button("Novice"), 
                                                    new Button("Regular"), new Button ("Expert"));
        levelButtons.setAlignment(Pos.CENTER);
        
        // create a VBox to act as the first card
        VBox levelPanel = new VBox(10);
        
        // add the label and buttons to the first VBox
        levelPanel.getChildren().addAll(levelLabel, levelButtons);
        levelPanel.setAlignment(Pos.CENTER);
        
        // create a label for the second card (choosing the character)
        Label characterLabel = new Label("    Choose your character    ");
        characterLabel.setFont(Font.font ("Verdana", 15));
              
        // create an HBox containing four dummy buttons for the second card (choosing the character)
        HBox characterButtons = new HBox(10);
        characterButtons.getChildren().addAll(new Button("Zorrkk"), new Button("Kluggg"), 
                                                    new Button ("Grrogg"), new Button("Skrankk"));
        characterButtons.setAlignment(Pos.CENTER);
        
        // create a VBox to act as the second card
        VBox characterPanel = new VBox(10);
        characterPanel.getChildren().addAll(characterLabel, characterButtons);
        characterPanel.setAlignment(Pos.CENTER);
        
        // create a label for the second card (choosing the location)
        Label locationLabel = new Label("Choose your location");
        locationLabel.setFont(Font.font ("Verdana", 15));
        
        // create an HBox containing two dummy buttons for the third card (choosing the location)
        HBox locationButtons = new HBox(10);
        locationButtons.getChildren().addAll(new Button("Castle of Doom"), 
                                                               new Button("Forest of Fear"));
        locationButtons.setAlignment(Pos.CENTER);
        
        // create a VBox to act as the third card
        VBox locationPanel = new VBox(10);
        locationPanel.getChildren().addAll(locationLabel, locationButtons);
        locationPanel.setAlignment(Pos.CENTER);  
        
             
        // create and configure buttons for moving back and forth through the cards
        Button nextButton = new Button(" Next  ");
        Button previousButton = new Button("Previous");
        
        nextButton.setFont(Font.font ("Verdana", 15));
        previousButton.setFont(Font.font ("Verdana", 15));
        
        // configure the stack pane 
        stack.setPadding(new Insets(10, 10, 10, 10));
        stack.setBackground(new Background(new BackgroundFill(Color.GOLD, 
                                                             CornerRadii.EMPTY, Insets.EMPTY)));
        stack.setAlignment(Pos.CENTER);
        
        // add the cards to the stack pane
        stack.getChildren().addAll(levelPanel, characterPanel, locationPanel);
      
        // show the first card and hide the other two
        stack.getChildren().get(0).setVisible(true); 
        stack.getChildren().get(1).setVisible(false); 
        stack.getChildren().get(2).setVisible(false); 
         
        // create and configure an HBox
        HBox root = new HBox(20);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);
        
        // add the "previous" button, the stack of cards and the "next" button 
        root.getChildren().addAll(previousButton, stack, nextButton);

        // add event handlers to call the relevant helper methods
        nextButton.setOnAction (e -> next());
        previousButton.setOnAction (e -> previous());
         

        // create and configure the scene
        Scene scene = new Scene(root, 500, 200, Color.DARKBLUE);
                      
        // configure the stage
        stage.setScene(scene);
        stage.setTitle("The Dungeons of Schpiltz");
        stage.show(); 
    }
    
    // define the helper method for the "next" button
    private void next()
    {
            if(currentCard !=  stack.getChildren().size()- 1) // if we are not at the last card
            {
                currentCard++; // make the next card the current card
                
                // move through the cards: show the current card, hide the others
                for(int i = 0; i <=  stack.getChildren().size()- 1; i++)
                {
                    if(i == currentCard)
                    {
                        stack.getChildren().get(i).setVisible(true);
                    }
                    else
                    {
                        stack.getChildren().get(i).setVisible(false);
                    }
                }
            }
    } 

    // define the helper method for the "previous" button
    private void previous()
    {
            if(currentCard != 0) // if we are not at the first card
            {
                currentCard--; // make the previous card the current card
                
                // move through the cards: show the current card, hide the others
                for(int i = 0; i <=  stack.getChildren().size()- 1; i++)
                {
                    if(i == currentCard)
                    {
                        stack.getChildren().get(i).setVisible(true);
                    }
                    else
                    {
                        stack.getChildren().get(i).setVisible(false);
                    }
                }
            }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}         
