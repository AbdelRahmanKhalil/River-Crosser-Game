/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */

public class Story2Controller /*implements IRiverCrossingController*/{
     Story2Model Model=new Story2Model();
    Story2View View=new Story2View();
    MenueController controller;
    int h=3;
    
    public Story2Controller()
    {
        
    }
    public void send(Story2Model model,Story2View view)
    {
        Model=model;
        View=view;
        Link();
        Model.setStage(View.getStage());
        //Model.RunStory1();
        
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
       
    }
     /*public void send(MenueController hi)
    {
        Model=hi.getModel();
        View=hi.getView();
        System.out.println("VIEW1="+View);
        System.out.println("MODEL1="+Model);
    }*/

    /*@Override
    */public void newGame(/*ICrossingStrategy newStrategy*/) {
        
       
       System.out.println("newgame");
    }

    //@Override
    public void resetGame() {
        System.out.println("reset");
    }/*

    @Override
    public String[] getInstructions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ICrosser> getCrossersOnRightBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ICrosser> getCrossersOnLeftBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfSails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(ArrayList<ICrosser> crossers, boolean fromLeftToRightBank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doMove(ArrayList<ICrosser> crossers, boolean fromLeftToRightBank) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        System.out.println("undo");
    }

    @Override
    public void redo() {
        System.out.println("redo");
    }

    @Override
    public void saveGame() {
        System.out.println("savegame");
    }

    @Override
    public void loadGame() {
        System.out.println("loadgame");
    }

    @Override
    public ArrayList<ArrayList<ICrosser>> solveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
