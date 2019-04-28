/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Story1Model {
    private ArrayList<Crosser> Crossers = new ArrayList<Crosser>();
    MoveDown moveDown;
    MoveUp moveUp;
    MoveLeft moveLeft;
    MoveRight moveRight;
    Action action ;
    private Stage stage;
    Crosser Controlled;
    public void getCrossers(ArrayList<Crosser> crossers)
    {
        this.Crossers=crossers;
    }
    public void RunStory1()
    {
        
        AnimationTimer timer = new AnimationTimer() {
            
            @Override
            
            public void handle(long now) {
               stage.getScene().setOnKeyPressed(e->{
                   if(Controlled==null)
                   {
                       
                   }
                   else
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
                        
                   
                  }
                   
               });
               stage.getScene().setOnMouseClicked(e->{
                 for(Crosser cross:Crossers)
                         {
                             if(e.getTarget()==cross.getAppearance())
                             {
                                 Controlled=cross;
                                 moveDown=new MoveDown(cross);
                                 moveUp = new MoveUp(cross);
                                 moveLeft=new MoveLeft(cross);
                                 moveRight=new MoveRight(cross);
                                 
                             }
                         }
                   
                   
                   
                   
               });
               
    }
            
                };
        timer.start();
    }
   public  void setStage(Stage stage)
    {
        this.stage=stage;
    }
}
