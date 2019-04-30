
package rivercrosser;
     
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Story1Model implements IRiverCrossingController{
    
    private ArrayList<Crosser> Crossers = new ArrayList<Crosser>();
    private ArrayList<Crosser> Crossed = new ArrayList<Crosser>();
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
    private Node Harbour1;
    private Node Harbour2;
    private boolean harb1;
    private boolean harb2;
    //Story1View View =new Story1View();
    public void setCrossers(ArrayList<Crosser> crossers)
     {
         
        this.Crossers=crossers;
        
     }
    public void setBoat(Boat b)
    { 
        boat=b;   
    }
    public Story1Model RunStory1()
    {
       harbourStatus();
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
                           
                        }
                   }
               });
           
               
               stage.getScene().setOnMouseClicked(e->{
                    
                 for(Crosser cross:Crossers)
                         {
                             if(e.getTarget()==cross.getAppearance())
                             {
                                 System.out.println("clicke");
                               //  Controlled= new Crosser();
                                // Controlled = cross;
                                 ControlThis(cross);
                                 break;
                             }
                            if(e.getTarget()==boat.Appearance)
                            {
                                if(boat.drivable==true)
                                {
                                   // Controlled = new Boat();
                                    //Controlled=boat;
                                    if(canMove(Crossers, harb1))
                                    {
                                        System.out.println("ye5");
                                         ControlThis(boat);
                                         
                                    }
                                        break;
                                }
                            }
                         }
             
               });
               
    
            
                return this;
      
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
   
   private void getOffBoat(int HarbourNumber)
   {

       //boat=(Boat) Controlled;
       System.out.println("getting off");
       int x=50;
       root.getChildren().remove(boat.Appearance);
       for(Crosser cross:onBoat)
       {
           
           if(HarbourNumber==1)
           {
               System.out.println("sout"+Harbour1.getTranslateX()+x);
           cross.getAppearance().setTranslateX(100);
           cross.getAppearance().setTranslateY(100);
           boat.Appearance.setTranslateX(Harbour1.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour1.getTranslateY());
           Crossers.add(cross);
           }
           if(HarbourNumber==2)
           {
               
           cross.getAppearance().setTranslateX(200);
           cross.getAppearance().setTranslateY(200);  
           boat.Appearance.setTranslateX(Harbour2.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour2.getTranslateY());
           Crossers.add(cross);
           }
           root.getChildren().add(cross.getAppearance());
           
           x=55;   
           boat.Passengers--;
       }
       
        onBoat.removeAll(onBoat);
        boat.drivable=false;
        Controlled=false;
        root.getChildren().add(boat.Appearance);
   }
   private void ControlThis(GameObject thing)
   {
       Controlled = true;
       moveDown=new MoveDown(thing);
       moveUp = new MoveUp(thing);
       moveLeft=new MoveLeft(thing);
       moveRight=new MoveRight(thing);
   }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getInstructions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Crosser> getCrossersOnRightBank() {
        return Crossers;
    }

    @Override
    public ArrayList<Crosser> getCrossersOnLeftBank() {
         return Crossed;
    }

    public boolean isBoatOnTheLeftBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfSails() {
     return 0;
    }

    @Override
    public boolean canMove(ArrayList<Crosser> crossers, boolean fromLeftToRightBank) {
        int i;
        int j;
        for(i=0;i<Crossers.size();i++)
        {
             if(i!=Crossers.size()-1)
                {

            for(j=i+1;j<Crossers.size();j++)
            {
                //System.out.println(" "+j);
                if(Crossers.get(i).getEatingRank()>Crossers.get(i).getEatingRank())
                {
                    return false;
                }
               
            }
                }
        }
        return true;
    }

    @Override
    public void doMove(ArrayList<Crosser> crossers, boolean fromLeftToRightBank) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public void harbourStatus()
  {
          if(boat.atHarbour(Harbour1))
                 {
                     harb1=true;
                     harb2=false;
                     if(boat.Passengers!=0)
                     getOffBoat(1);
                 }
                 else if(boat.atHarbour(Harbour2))
                 {
                     if(boat.Passengers!=0)
                     harb2=true;
                     harb1=false;
                     getOffBoat(2);
                 }
                 else {
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
                                //harb1=true;
                            }
                                getOnBoat(cross);
                                break;
                                
                    }
                }
               
            }
                 }  
  }
    @Override
    public boolean canUndo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canRedo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ArrayList<ICrosser>> solveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void setHarbour1(Node harbour1)
   {
       this.Harbour1=harbour1;

   }
   public void setHarbour2(Node harbour2)
   {
       this.Harbour2=harbour2;
   }
}
