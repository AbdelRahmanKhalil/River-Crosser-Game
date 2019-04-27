/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MenueController implements Initializable {

     MenueView theView;
     MenueModel theModel;
     Stage WindowReal;
 
    public MenueController() {
        
    } 
    public MenueController(MenueView theView, MenueModel theModel,Stage WindowFake) {
        System.out.println("Constructed Menue controller (we have view and model for main menue osama)");
        this.theView = theView;
        this.theModel = theModel;
        WindowReal=WindowFake;
    }
    public void displayStory1() throws IOException
    {
       Story1View view=new Story1View();
       Story1Model model = new Story1Model();
       //Stage window=theView.getStage();
       view.setStage(WindowReal);
       Story1Controller controller =new Story1Controller(view,model);
       System.out.println("ENTER");
      
       view.display();
    }
    public void displayStory2()
    {
        //theModel.startStory2();
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
