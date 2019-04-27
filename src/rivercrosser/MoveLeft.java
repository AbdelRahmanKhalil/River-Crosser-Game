/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

/**
 *
 * @author Osama PC
 */
public class MoveLeft implements Command{

    Crosser obj;
    
    public MoveLeft(Crosser obj)
    {
        this.obj=obj;
    }
    public void execute() {
        obj.moveLeft();
    }

    public void undo() {
        obj.moveRight();
    }
    
}
