/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.io.IOException;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class MenueModel {
    
    
    public void startStory1(Stage Window) throws IOException
    {
       Story1View view=new Story1View();
       Story1Model model = new Story1Model();
       Story1Controller controller =new Story1Controller(view,model);
       view.setStage(Window);
       view.display();
    }
    public void startStory2()
    {
        
    }
}
