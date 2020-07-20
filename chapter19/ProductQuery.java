// accessing a database using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductQuery extends Application
       
{
    public static final String URL = "jdbc:mysql://localhost/ElectricalStore?useSSL=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Petergoat1";    
    
    @Override
    public void start(Stage stage) 
    {
        // create VBoxes to act as display columns
        VBox data1 = new VBox();
        VBox data2 = new VBox();
        VBox data3 = new VBox();
        VBox data4 = new VBox();
        
        data1.getChildren().add(new Text("Serial Number\n"));
        data2.getChildren().add(new Text("Make\n"));
        data3.getChildren().add(new Text("Description\n"));
        data4.getChildren().add(new Text("Price\n"));

        Connection con;
        Statement st;
        ResultSet result;
        
        
        try
        {
            // connect to the database
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
 
            // create an SQL statement
            st = con.createStatement();

            // execute an SQL query
            result = st.executeQuery("select * from products");
      
            while(result.next()) // move to next record
            {

                // retrieve and display first field
                data1.getChildren().add(new Text (result.getString(1)));
                // retrieve and display second field
                data2.getChildren().add(new Text(result.getString(2)));
                // retrieve and display third field
                data3.getChildren().add(new Text(result.getString(3)));
                // retrieve and display fourth field
                data4.getChildren().add(new Text("£" + result.getString(4)));
            }
        }       

        catch(SQLException e) // handle the SQLException
        {
            
        }
        
        // configure the visual components
        HBox root = new HBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(data1, data2, data3, data4);
        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Electrical Store");
        stage.setScene(scene);
        stage.show();                
    }
   
    public static void main(String[] args)
    {
	launch(args);
    }
}

