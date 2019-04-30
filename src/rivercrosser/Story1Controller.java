/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;

/**
 *
 * @author Lenovo
 */
public class Story1Controller implements ICrossingStrategy{
    
    Story1Model Model=new Story1Model();
    Story1View View =new Story1View();
    MenueController controller;
    public Story1Controller()
    {
        
    }
    public void send(Story1Model model,Story1View view)
    {
        
        Model=model;
        View=view;
        Link();
        Model.setStage(View.getStage());
        run();
        System.out.println("hi");
    }
    public void sayHi()
    {
        System.out.println("HI SALOOHA");
    }
    public void Link()
    {
        Model.setCrossers(View.getCrossers());
        Model.setBoat(View.getBoat());
        Model.setRoot(View.getRoot());
        Model.setHarbour1(View.getHarbour1());
        Model.setHarbour2(View.getHarbour2());
    }
     /*public void send(MenueController hi)
    {
        Model=hi.getModel();
        View=hi.getView();
        System.out.println("VIEW1="+View);
        System.out.println("MODEL1="+Model);
    }*/

    @Override
    public boolean isValid(ArrayList<Crosser> Crossed, ArrayList<Crosser> Waiting, List<Crosser> onBoat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Crosser> getInitialCrossers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getInstructions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void run()
   {
       AnimationTimer timer;
        timer = new AnimationTimer() {
            
            @Override
            public void handle(long now) {
            Model.RunStory1();
            } 
        };
        timer.start();
   }
}
