/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import javafx.scene.Node;

/**
 *
 * @author Lenovo
 */
public class Plant extends Crosser{

    public Plant(Node Appearance, int Weight, String Name,boolean sail) {
        super(Appearance, Weight, Name,sail);
        sailingType=new CantSail();
    }
    
}
