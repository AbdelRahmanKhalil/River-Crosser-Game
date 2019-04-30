/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Story2Model {
     private ArrayList<Crosser> Crossers = new ArrayList<Crosser>();
    private ArrayList<Crosser> onBoat = new ArrayList<Crosser>();
    MoveDown moveDown;
    MoveUp moveUp;
    MoveLeft moveLeft;
    MoveRight moveRight;
    Action action ;
    private Stage stage;
    boolean Controlled;
    private Boat boat;
    private Pane root;
    public void setCrossers(ArrayList<Crosser> crossers)
     {
         
        this.Crossers=crossers;
        
     }
    public void setBoat(Boat b)
    {
        
        boat=b;
        
    }
     public void setRoot(Pane root)
   {
       this.root=root;
   }
   public  void setStage(Stage stage)
    {
        this.stage=stage;
    }
   private void getOnBoat(Crosser crosser)
   {
       onBoat.add(crosser);
       System.out.println("added");
       Crossers.remove(crosser);
       root.getChildren().remove(crosser.getAppearance());
       boat.Passengers++;
   }
}
