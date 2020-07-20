
// accessing a database using Hibernate

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProductQuery2 extends Application 
{
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
       
        HBox root = new HBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(data1, data2, data3, data4);

        // configure the stage
        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Electrical Store");
        stage.setScene(scene);
        stage.show();

        // create a Configuration object
        Configuration cfg = new Configuration();
        
        // link the configuration object to the database properties
        cfg.configure("hibernate.cfg.xml");              
        
        // specify the mapping file
        cfg.addResource("hibernate.hbm.xml");
  
        // create a Session object to act as an interface between the Java application and Hibernate
        ServiceRegistry serviceRegistry 
                 = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory  sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
               
        Transaction tx = session.beginTransaction();
         
        // query the database
        Query query = session.createQuery("from Product");
        
        // create a list of products from the query
        ArrayList<Product> list = (ArrayList) query.list();
        
        // display the product details for each product in the list
        for(Product pr : list)
        {
            data1.getChildren().add(new Text(pr.getStockNumber()));
            data2.getChildren().add(new Text(pr.getManufacturer()));
            data3.getChildren().add(new Text(pr.getItem()));
            data4.getChildren().add(new Text("£" + pr.getUnitPrice()));
        }
        
        // close the session
        session.close();
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        
    }
        
    public static void main(String[] args)
    {
        launch(args);
    }
}





