/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Story1View 
    {
    
    private Stage Window;
    private CrosserFactory Generator= new CrosserFactory();
    Pane root;
    private ArrayList<Crosser> Crosssers= new  ArrayList<>();
    private Boat boat;
    public void setStage(Stage window)
    {
        Window=window;
    }
    public Story1Controller display() 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Story1.fxml"));
        
        try {
            root = loader.load();
            Window.setScene(new Scene(root));
            Window.show();
        } catch (IOException ex) {
            Logger.getLogger(Story1View.class.getName()).log(Level.SEVERE, null, ex);
        }
        Setup();
        Story1Controller controller=loader.getController();
        System.out.println("Cont="+controller);
        
        return controller;
        
    }

    private void addCrosser(Crosser crosser,double x,double y)
    {
        crosser.getAppearance().setTranslateX(x);
        crosser.getAppearance().setTranslateY(y);
        Crosssers.add(crosser);        
        root.getChildren().add(crosser.getAppearance());
    }
    private void Setup()
    {
        
        addBoat();
        addCrosser(Generator.createCrosser("Farmer",0),100,100); 
        addCrosser(Generator.createCrosser("Herbivore",0),200,100); 
        addCrosser(Generator.createCrosser("Carnivore",0),300,100); 
        addCrosser(Generator.createCrosser("Plant",0),400,100); 
           
    }
    private void addBoat()
    {
        boat = new Boat();
        boat.Appearance.setTranslateX(100);
        boat.Appearance.setTranslateY(200);
        root.getChildren().add(boat.Appearance);
    }
    public ArrayList getCrossers()
    {
      return this.Crosssers;  
    }
    public Boat getBoat()
    {
        return this.boat;
    }
    public Stage getStage()
    {
      return this.Window;  
    }
    public Pane getRoot()
    {
        return this.root;
    }
}