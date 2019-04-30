
package rivercrosser;
     
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Story1Model {
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
    //Story1View View =new Story1View();
    public void setCrossers(ArrayList<Crosser> crossers)
     {
         
        this.Crossers=crossers;
        
     }
    public void setBoat(Boat b)
    {
        
        boat=b;
        
    }
    public void RunStory1()
    {
        
        AnimationTimer timer = new AnimationTimer() {
            
            //@Override
            
            public void handle(long now) {
               stage.getScene().setOnKeyPressed(e->{
                   
                   if(Controlled ==true)
                   {
                       
                   
                         if(e.getCode()==KeyCode.DOWN)
                        {
                             moveDown.execute();
                        }
                        if(e.getCode()==KeyCode.UP)
                        {
                             moveUp.execute();
                        }
                        if(e.getCode()==KeyCode.LEFT)
                        {
                            moveLeft.execute();
                        }
                        if(e.getCode()==KeyCode.RIGHT)
                        {
                            moveRight.execute();
                        }
                         if(e.getCode()==KeyCode.E)
                        {
                            if(onBoat!=null)
                            {
                            getOffBoat();
                            }
                        }
                   }
               });
            for(Crosser cross:Crossers)
            {
                
                if(cross.isColliding(boat))
                {
                    if(boat.Passengers<2)
                    {
                        System.out.println("getting on");
                        if(cross instanceof Farmer)
                            {
                                boat.drivable=true;
                            }
                                getOnBoat(cross);
                                
                    }
                }
            }
               
               stage.getScene().setOnMouseClicked(e->{
                    
                 for(Crosser cross:Crossers)
                         {
                             if(e.getTarget()==cross.getAppearance())
                             {
                                 System.out.println("clicke");
                               //  Controlled= new Crosser();
                                // Controlled = cross;
                                 ControlThis(cross);
                             }
                            if(e.getTarget()==boat.Appearance)
                            {
                                if(boat.drivable==true)
                                {
                                   // Controlled = new Boat();
                                    //Controlled=boat;
                                    ControlThis(boat);
   
                                }
                            }
                         }
                   
               });
               
    }
            
                };
        timer.start();
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
   
   private void getOffBoat()
   {

       //boat=(Boat) Controlled;
       //System.out.println("getting off");
       for(Crosser cross:onBoat)
       {
           
           Crossers.add(cross);
           cross.getAppearance().setTranslateX(boat.Appearance.getTranslateX()+10);
           cross.getAppearance().setTranslateY(boat.Appearance.getTranslateY()+10);
           root.getChildren().add(cross.getAppearance());
           
       }
        onBoat.removeAll(onBoat);
        boat.drivable=false;
        boat.Passengers=0;
        Controlled=false;
   }
   private void ControlThis(GameObject thing)
   {
       Controlled = true;
       moveDown=new MoveDown(thing);
       moveUp = new MoveUp(thing);
       moveLeft=new MoveLeft(thing);
       moveRight=new MoveRight(thing);
   }
}
