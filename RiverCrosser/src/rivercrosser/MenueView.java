/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class MenueView {
    

/**
 *
 * @author Lenovo
 */

    
     Stage Window;
    
    public void setStage(Stage MenueWindow)
    {
        System.out.println("ENTER2");
        Window=MenueWindow;
    }
    
    
     public void display() throws IOException{
        
        Pane root = FXMLLoader.load(getClass().getResource("Menue.fxml"));
        //CrosserFactory f=new CrosserFactory();
       // Crosser tester=f.createCrosser("plant", 0);
        //tester.getAppearance().setTranslateX(200);
        //tester.getAppearance().setTranslateY(300);
        //root.getChildren().add(tester.getAppearance());
        Window.setScene(new Scene(root,600,400));
        Window.show();
        
        
    }
    public Stage getStage()
    {
        System.out.println("ENTER3");
        return Window;
    }
}

    
