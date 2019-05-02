
package rivercrosser;
     
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//Y-AXIS 221 UPPER Y-AXIS 430 LOWER
//X-AXIS 557 RIGHT X-AXIS 38 LEFT
public class Story1Model {
    
    private ArrayList<Crosser> Crossers = new ArrayList<Crosser>();
    private ArrayList<Crosser> Crossed = new ArrayList<Crosser>();
    private ArrayList<Crosser> onBoat = new ArrayList<Crosser>();
    private ArrayList<Crosser> onShore = new ArrayList<Crosser>();
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
    private Node Border1;
    private Node Border2;
    
    GameObject player;
    //Story1View View =new Story1View();
    public void setCrossers(ArrayList<Crosser> crossers)
     {
         
        this.Crossers=crossers;
        this.onShore=crossers;

        
     }
    public void setBoat(Boat b)
    { 
        boat=b;   
    }
    public Story1Model RunStory1()
    {
        Border1.setVisible(false);
        Border2.setVisible(false);
       harbourStatus();
               stage.getScene().setOnKeyPressed(e->{
                   
                   if(Controlled ==true)
                   {
                         if(player instanceof Boat)
                         {canMove();}
                         if(e.getCode()==KeyCode.DOWN)
                        {
                           
                            if(player.Appearance.getTranslateY()<550&&player.Appearance.getBoundsInParent().intersects(Border2.getBoundsInParent())==false&&boat.Appearance.getBoundsInParent().intersects(Border1.getBoundsInParent())==false)
                             moveDown.execute();
                            
                        }
                        if(e.getCode()==KeyCode.UP)
                        {
                             if(player.Appearance.getTranslateY()>60&&player.Appearance.getBoundsInParent().intersects(Border1.getBoundsInParent())==false&&boat.Appearance.getBoundsInParent().intersects(Border2.getBoundsInParent())==false)
                             {
                                
                                moveUp.execute();
                             }
                        }
                        if(e.getCode()==KeyCode.LEFT)
                        {
                            System.out.println(" X = "+player.Appearance.getTranslateX());
                            if(player.Appearance.getTranslateX()>30)
                            moveLeft.execute();
                        }
                        if(e.getCode()==KeyCode.RIGHT)
                        {
                           if(player.Appearance.getTranslateX()<540)
                            moveRight.execute();
                        }
                         if(e.getCode()==KeyCode.E)
                        {
                           if(harb1==true)
                           {
                               getOffBoat(1);

                           }
                            if(harb2==true)
                            {
                                getOffBoat(2);

                            }
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
                                    if(true)
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

       if(harb2==true) {
           onShore.remove(crosser);

       }
       System.out.println("masha "+crosser.getName());
       crosser.getAppearance().setTranslateX(0);
       crosser.getAppearance().setTranslateY(0);
       root.getChildren().remove(crosser.getAppearance());
       boat.Passengers++;

   }
  
   private void getOffBoat(int HarbourNumber)
   {

       //boat=(Boat) Controlled;
       System.out.println("getting off");
       double x=45;
       root.getChildren().remove(boat.Appearance);
       for(Crosser cross:onBoat)
       {
            System.out.println("hi "+cross.getName());
           if(HarbourNumber==1)
           {
          
           cross.getAppearance().setTranslateX(Harbour1.getTranslateX()+x);
           cross.getAppearance().setTranslateY(435);
           boat.Appearance.setTranslateX(Harbour1.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour1.getTranslateY()-30);
           Crossers.add(cross);
           Crossed.add(cross);
           harb1=true;
           harb2=false;
    //        <BorderPane layoutX="36.0" layoutY="426.0" prefHeight="158.0" prefWidth="534.0" />
     // <BorderPane layoutX="46.0" layoutY="48.0" prefHeight="171.0" prefWidth="514.0" />
           }
           if(HarbourNumber==2)
           {
               
           cross.getAppearance().setTranslateX(Harbour2.getTranslateX()-x);
           cross.getAppearance().setTranslateY(160);  
           boat.Appearance.setTranslateX(Harbour2.getTranslateX()+45);
           boat.Appearance.setTranslateY(Harbour2.getTranslateY()+30);
           Crossers.add(cross);
           onShore.add(cross);
               System.out.println("wasal "+cross.getName());
           
           harb2=true;
           harb1=false;
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
        player=thing;
       moveDown=new MoveDown(thing);
       moveUp = new MoveUp(thing);
       moveLeft=new MoveLeft(thing);
       moveRight=new MoveRight(thing);
   }

    

    public boolean isBoatOnTheLeftBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void canMove() {
        int i;
        int j;
        if(harb2==true) {
            for (i = 0; i < onShore.size(); i++) {


                    for (j = 0; j < onShore.size(); j++) {
                        System.out.println(" eating rank " + onShore.get(i).getEatingRank());
                        if (onShore.get(i).getEatingRank() == onShore.get(j).getEatingRank() + 1) {
                            System.out.println("m3elsalama");//window yetla3 aw ay ebn metnaka
                        }

                    }

            }

        }


        if(harb1==true) {
            for (i = 0; i < Crossed.size(); i++) {


                    for (j = i; j < Crossed.size(); j++) {
                        if (Crossed.get(i).getEatingRank() == Crossed.get(j).getEatingRank() + 1) {
                            System.out.println("M3 el salama"); //window yetla3 aw ay ebn metnaka
                        }

                    }

            }

        }
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
             
                if(cross.isColliding(Harbour1)&&harb1==true)
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
                if(cross.isColliding(Harbour2)&&harb2==true)
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
   
   public void setHarbour1(Node harbour1)
   {
       this.Harbour1=harbour1;
       harb2=true;
       
   }
   public void setHarbour2(Node harbour2)
   {
       this.Harbour2=harbour2;
       
   }
   public void getBorder1(Node border)
   {
       Border1=border;
   }
   public void getBorder2(Node border)
   {
       Border2=border;
   }
}
