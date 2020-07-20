package airportSys; // add class to package

import java.util.Set;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * Class to provide the JavaFX interface of the airport system
 * 
 * @author Charatan and Kans
 * @version 6th August 2018
 */

public class AirportFrame extends Application
{
    // declare Airport object 
    private Airport myAirport;
    // additional data required for the airport system
    private int numberOfRunways ;
    private final String FILENAME = "airport.dat";
    
    // create arrival and departure visual components that need global access

    // arrivals information displayed in a HBox
    private HBox arrivals = new HBox(50);
    // include columns for arrivals information    
    private   VBox arrivalsColumn1 = new VBox();
    private   VBox arrivalsColumn2 = new VBox();
    private   VBox arrivalsColumn3 = new VBox();
    private   VBox arrivalsColumn4 = new VBox();
    // departures information displayed in a HBox
    private   HBox departures = new HBox(60);
    // include columns for departures information   
    private   VBox departuresColumn1 = new VBox();
    private   VBox departuresColumn2 = new VBox();
    private   VBox departuresColumn3 = new VBox();    
    
    // methods

    /**
     * The start method to initialise the screen and the airport data
     *
     * @param	stage The Stage object
     */
    @Override
    public void start(Stage stage) 
    {
        // check if data is to be loaded from file
        Alert alert = new Alert(	AlertType.INFORMATION, "Do you want to restore your data?",
 										ButtonType.YES, ButtonType.NO);
        String response = alert.showAndWait().get().getText();
        if (response.equals("Yes")) // load data from file
        {            
            try
            {
                myAirport = new Airport(FILENAME); // call file loading constructor
                listArrivals(); // update arrivals tab
                listDepartures(); // update departures tab
                showInfo("Planes loaded");
            }
            catch (Exception e) // file loading errors
            {
                showError("File Opening error");
                System.exit(1); // indicates exit with error
            }                        
        }
        else // initialise an empty airport
        {            
            numberOfRunways = getNumberOfRunways(); // request number of runways
            try
            {
                myAirport = new Airport (numberOfRunways); // create an empty Airport object
            }
            catch (AirportException ae) // error initialising Airport object
            { 
                showError(ae.getMessage());
                System.exit(1); // indicates exit with error
            }
            catch (Exception e) // in case of any unforseen error
            { 
                showError(e.getMessage());
                System.exit(1); // indicates exit with error
            }
        }
        // set up three Tab objects in a TabPane
        TabPane tabbedPane = new TabPane();
        Tab tab1 = new Tab("Flight Control"); // main flight control tabs
        Tab tab2 = new Tab("Flight Arrivals"); // arrivals tab
        Tab tab3 = new Tab("Flight Departures"); // departures tab
        tabbedPane.getTabs().addAll(tab1, tab2, tab3);
        // ensure tabs remain open
        tab1.setClosable(false);
        tab2.setClosable(false);
        tab2.setClosable(false);
        
        // creat a VBox to hold all scene components 
        VBox root = new VBox();
        
		 // set up menu bar and items
        MenuBar bar = new MenuBar();
        bar.setMinHeight(25);
        Menu item = new Menu("File");
        Menu saveAndContinueOption = new Menu("Back-up and continue");
        Menu saveAndExitOption = new Menu("Back-up and exit"); 
        Menu exitWithoutSavingOption = new Menu("Exit without backing-up");
        item.getItems().addAll(saveAndContinueOption, saveAndExitOption, exitWithoutSavingOption);
        bar.getMenus().add(item);        
        
        // create and customise a VBox to organise flight control screen
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setMinHeight(215);
        // add Vbox to tab1
        tab1.setContent(box);
        box.setAlignment(Pos.BOTTOM_LEFT);
        // create a cloud image
        Image image = new Image("clouds.png");  
        ImageView imageView = new ImageView(image); 
        // create an instructional label
        Label label = new Label("Enter an option");
        // create a HBox to hold main flight control buttons
        HBox controls = new HBox(10);
        // create flight control buttons and add tooltips
        Button button1 = new Button("Register");
        button1.setTooltip(new Tooltip("Register a flight with the airport"));
        Button button2 = new Button("Request to land");
        button2.setTooltip(new Tooltip("Record a flight requesting to land at the airport"));
        Button button3 = new Button("Land");
        button3.setTooltip(new Tooltip("Record a flight landing at the airport"));
        Button button4 = new Button("Board");
        button4.setTooltip(new Tooltip("Record a landed flight ready for boarding new passengers"));
        Button button5 = new Button("Take off");
        button5.setTooltip(new Tooltip("Record a flight leaving the airport"));
        // add buttons to HBox
        controls.getChildren().addAll(button1, button2, button3, button4, button5);
        // add cloud image, label and button collection to VBox
        box.getChildren().addAll(imageView,label, controls);
        try
        {
            // code button responses by calling private methods
            button1.setOnAction(e -> register());
            button2.setOnAction(e -> requestToLand());
            button3.setOnAction(e -> land());
            button4.setOnAction(e -> board());
            button5.setOnAction(e -> takeOff());
            // code menu responses
            saveAndContinueOption.setOnAction(e -> save(FILENAME));
            saveAndExitOption.setOnAction(e ->{
                                                save(FILENAME);
                                                Platform.exit();
                                              });
            exitWithoutSavingOption.setOnAction(e -> exitWithoutSaving());   
        }
        catch(Exception e) // for any unforseen errors
        {
            showError("Invalid Operation");
        }
           
        // customise look of arrivals tab
        arrivals.setPadding(new Insets(10));
        arrivals.getChildren().addAll(	arrivalsColumn1, arrivalsColumn2, arrivalsColumn3,
 												arrivalsColumn4);
        tab2.setContent(arrivals);
        // customise look of departures tab
		 departures.setPadding(new Insets(10));      
        departures.getChildren().addAll(departuresColumn1, departuresColumn2, departuresColumn3);
        tab3.setContent(departures);       
        // customise root object and add menu and tabbed pane    
        root.setBorder(	new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
							new CornerRadii(0), new BorderWidths(2))));
        root.getChildren().addAll(bar, tabbedPane);
        // customise frame
        Scene scene = new Scene(root,450, 275);
        stage.setScene(scene);
        stage.setTitle("Airport System");
        stage.initStyle(StageStyle.UNDECORATED); // for undecorated frame

        stage.show(); 
    }
    
    /**
     *  Private method to request and return the number of runways
     */
    private int getNumberOfRunways()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter number of runways");
        dialog.setTitle("Runway Information Request");
          
        String response = dialog.showAndWait().get(); 
        
        if (!response.equals("")) // check for empty string
        {
            return Integer.parseInt(response);
        }
        else
        {
            return -1; // to indicate no runway set
        }         
    }
    
    /**
     *  Private method to register new flight with the airport
     */
    private void register()            
    {       
        String flightNo, city;
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter flight number");
            dialog.setTitle("Registration form");
            flightNo = dialog.showAndWait().get();
            
            // throws AirportException if no flight entered
            checkIfEmpty(flightNo, "No flight number entered");
            
            dialog = new TextInputDialog();
            dialog.setHeaderText("Enter city of origin");
            dialog.setTitle("Registration form");
            city = dialog.showAndWait().get();
            
            // throws AirportException if no city entered
            checkIfEmpty(city, "No city entered");
            
            // register flight        
            myAirport.registerFlight(flightNo, city);
            showInfo("confirmed:\nflight "+flightNo +" registered from "+city);
        }
        catch(AirportException ae) // catch airport exceptions
        {
            showError(ae.getMessage());
        }
        listArrivals();  // update arrivals tab
    }
    
    /**
     *  Private method to record a flight's request to land
     */
    private void requestToLand()            
    {       
        String flightNo, message;
        
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter flight number");
            dialog.setTitle("Request to land form");
            flightNo = dialog.showAndWait().get();
            
            // throws AirportException if no flight entered
            checkIfEmpty(flightNo, "No flight number entered");               
            
            // record flight's request to land and get runway number        
            int runway = myAirport.arriveAtAirport(flightNo);    
            // check runway number
            if (runway == 0)
            {
                message = "no runway available, circle the airport";
            }
            else
            {
               message = " land on runway "+runway;
            }
            showInfo("confirmed:\nflight "+flightNo + message);
        }
        catch(AirportException ae) // catch airport exceptions
        {
            showError(ae.getMessage());
        }
        listArrivals(); // update arrivals tab
    }
    
    /**
     *  Private method to record a flight landing at the airport
     */
    private void land()
    {
        String flightNo, runwayIn;
        int runway;
        
        try
        {            
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Enter flight number");
            dialog.setTitle("Landing form");
            flightNo = dialog.showAndWait().get();
            
            // throws AirportException if no flight entered
            checkIfEmpty(flightNo, "No flight number entered");
        
            dialog = new TextInputDialog();
            dialog.setHeaderText("Enter runway number");
            dialog.setTitle("Landing form");
            runwayIn = dialog.showAndWait().get();
            
            // throws AirportException if no runway enetered
            checkIfEmpty(flightNo, "No flight number entered"); 
            
            // convert runway to an integer
            runway = Integer.parseInt(runwayIn);
            // record flight landing
            myAirport.landAtAirport(flightNo, runway);
            showInfo("confirmed:\nflight "+flightNo +" landed on runway "+runway);
        }
        catch (AirportException ae) // catch airport exceptions
        {
           showError(ae.getMessage());
        }
        listArrivals(); // update arrivals tab
    }
    
    /**
     *  Private method to register a flight boarding passengers at the airport
     */
    private void board ()
    {
        String flightNo, city;
        
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Fight number");
            dialog.setTitle("Boarding form");
            flightNo = dialog.showAndWait().get();
        
            // throws AirportException if no flight entered
            checkIfEmpty(flightNo, "No flight number entered");
        
            dialog = new TextInputDialog();
            dialog.setHeaderText("Enter destination city");
            dialog.setTitle("Boarding form");
            city = dialog.showAndWait().get();
            
            // throws AirportException if no city entered
            checkIfEmpty(city, "No city entered");
            
            // record flight boarding
            myAirport.readyForBoarding(flightNo, city);
            showInfo("confirmation:\nflight "+flightNo+" boarding to "+city);
        }
        catch (AirportException ae) // catch airport exceptions
        {
           showError(ae.getMessage());
        } 
        listArrivals(); // update arrivals tab
        listDepartures(); // update departures tab
    }
    
    /**
     *  Private method to register a flight leaving the airport
     */
    private void takeOff ()
    {
        String flightNo;
        
        try
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Fight number");
            dialog.setTitle("Take off form");
            flightNo = dialog.showAndWait().get();
        
            // throws AirportException if no flight entered
            checkIfEmpty(flightNo, "No flight number entered");
        
            // record flight taking off
            myAirport.takeOff(flightNo);
            showInfo("confirmation:\nflight "+flightNo+" Removed from system");
        }
        catch (AirportException ae) // catch airport exceptions
        {
           showError(ae.getMessage());
        }        
        listDepartures(); // update departures tab
    }
    
    /**
     *  Private method to update arrivals tab information
     */
    private void listArrivals() 
    {
      // get arrivals information
      Set<Plane> arrivalsList = myAirport.getArrivals();
      // clear current arrivals information
      arrivalsColumn1.getChildren().clear();
      arrivalsColumn2.getChildren().clear();
      arrivalsColumn3.getChildren().clear();
      arrivalsColumn4.getChildren().clear();
      arrivalsColumn1.getChildren().add(new Text("FLIGHT"));
      arrivalsColumn2.getChildren().add(new Text("FROM"));
      arrivalsColumn3.getChildren().add(new Text("STATUS"));
      arrivalsColumn4.getChildren().add(new Text("RUNWAY"));
      // re-populate arrivals information
      for (Plane thisPlane: arrivalsList)
      {
        arrivalsColumn1.getChildren().add(new Text(thisPlane.getFlightNumber()));
        arrivalsColumn2.getChildren().add(new Text(thisPlane.getCity()));
        
        arrivalsColumn3.getChildren().add(new Text(thisPlane.getStatusName()));
        try
        {
            // throws exception if no runway set
            arrivalsColumn4.getChildren().add(
                                          new Text(Integer.toString(thisPlane.getRunwayNumber())));   
        }
        catch(Exception e) // catch exception and leave runway column blank
        {
             arrivalsColumn4.getChildren().add(new Text(""));
        }
     }
    }
    
    /**
     *  Private method to update departures tab information
     */
    private void listDepartures() 
    {
      // get departures information
      Set<Plane> departuresList = myAirport.getDepartures();
      // clear current departures information
      departuresColumn1.getChildren().clear();
      departuresColumn2.getChildren().clear();
      departuresColumn3.getChildren().clear();
      departuresColumn1.getChildren().add(new Text("FLIGHT"));
      departuresColumn2.getChildren().add(new Text("TO"));
      departuresColumn3.getChildren().add(new Text("RUNWAY"));
      // re-populate departures information
      for (Plane thisPlane: departuresList)
      {
        departuresColumn1.getChildren().add(new Text(thisPlane.getFlightNumber()));
        departuresColumn2.getChildren().add(new Text(thisPlane.getCity()));
             
        try
        {
            // throws exception if no runway set
            departuresColumn3.getChildren().add(
                                          new Text(Integer.toString(thisPlane.getRunwayNumber())));
        }
        catch(Exception e) // catch exception and leave runway column blank
        {
            departuresColumn3.getChildren().add(new Text(""));
        }
     }   
    }
    
    /**
     *  Private method to exit application without saving data
     */
    private void exitWithoutSaving()
    {
        Alert alert = new Alert(	AlertType.WARNING, "Are you sure? Your work could be lost.",
 										ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Confirmation reqired");
        String response = alert.showAndWait().get().getText();
        
        if(response.equals("Yes"))
        {
            Platform.exit();
        }
    }
  
    /**
     *  Private method to load airport data from a file
     *  @param 	fileName The name of the file to open
     */    
    private void open(String fileName)
    {
        try
        {
            myAirport.load(fileName); // may throw an exception
            listArrivals(); // update arrivals tab
            listDepartures(); // update departures tab
            showInfo("Planes Loaded");            
        }
        catch (Exception e) // catch file related exceptions
        {
            showError("File Opening error");
            System.exit(1); // indicates exit with error
        }
    }

    /**
     *  Private method to save airport data to a file
     *  @param 	fileName The name of the file to save
     */    
 	 private void save(String fileName)
    {
        try
        {
            myAirport.save(fileName); // may throw exception
            showInfo("Planes saved");
        }
        catch (Exception e) // catch file related exceptions
        {
            showError("Error saving data");
        }
    }
    
    /**
     *  Private method to show an error message
     *  @param 	msg The error message
     */
    private void showError(String msg)
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Airport Error Alert");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    /**
     *  Private method to show an information message
     *  @param 	msg The information message
     */
    private void showInfo(String msg)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Airport Information Alert");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    /**
     *  Private method to check if a string is empty
     *  @param  s The string to check
     *  @param  errorMessage The error message to include in an exception
     *  @throws AirportException if string is empty
     */
    private void checkIfEmpty(String s, String errorMsg)
    {
        if (s.equals(""))
        {
            throw new AirportException (errorMsg);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

