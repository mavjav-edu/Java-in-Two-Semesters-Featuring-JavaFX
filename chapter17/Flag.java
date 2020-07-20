
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Flag extends Application
{ 
    @Override
    public void start(Stage stage)
    {
        final double WIDTH = 400;
        final double HEIGHT = 200;
        
        // create and configure a menu bar
        MenuBar bar = new MenuBar();
        bar.setMinHeight(25);
        
        // create drop-down menus
        Menu topStripeMenu = new Menu("Top Colour");
        Menu middleStripeMenu = new Menu("Middle Colour");
        Menu bottomStripeMenu = new Menu("Bottom Colour");
        
        // add the drop-down menus to the menu bar
        bar.getMenus().addAll(topStripeMenu, middleStripeMenu, bottomStripeMenu);
        
        // create menu items - two for each drop-down menu
        Menu red = new Menu("Red");
        Menu blue = new Menu("Blue");
        
        Menu gold = new Menu("Gold");
        Menu orange = new Menu("Orange");
        
        Menu green = new Menu("Green");
        Menu purple = new Menu("Purple");
      
        // add menu items to drop-down menus
        topStripeMenu.getItems().addAll(red, blue);              
        middleStripeMenu.getItems().addAll(gold, orange);          
        bottomStripeMenu.getItems().addAll(green, purple);
                
        
        // create the stripes
        Rectangle topStripe = new Rectangle(WIDTH, (HEIGHT-25)/3);
        Rectangle middleStripe = new Rectangle(WIDTH, (HEIGHT-25)/3);
        Rectangle bottomStripe = new Rectangle(WIDTH, (HEIGHT-25)/3);
        
        // set initial colours
        topStripe.setFill(Color.RED);
        middleStripe.setFill(Color.GOLD);
        bottomStripe.setFill(Color.GREEN);
        
        // define the behaviour for each menu item
        red.setOnAction(e ->  topStripe.setFill(Color.RED));
        blue.setOnAction(e ->  topStripe.setFill(Color.BLUE));
        gold.setOnAction(e ->  middleStripe.setFill(Color.GOLD));
        orange.setOnAction(e ->  middleStripe.setFill(Color.ORANGE));
        green.setOnAction(e ->  bottomStripe.setFill(Color.GREEN));
        purple.setOnAction(e ->  bottomStripe.setFill(Color.PURPLE));
      
        // create VBox to hold the menu bar and the stripes
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT);
        root.setBackground(Background.EMPTY);
        root.getChildren().addAll(bar, topStripe, middleStripe, bottomStripe);
        
        // create the scene and add the VBox
        Scene scene = new Scene(root, WIDTH, HEIGHT);
       
        // confgure the stage       
        stage.setScene(scene);
        stage.setTitle("Dropdown Menu Example");
        stage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}    
        
