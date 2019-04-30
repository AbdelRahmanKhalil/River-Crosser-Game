/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.util.ArrayList;
import java.util.List;


public interface ICrossingStrategy {
    public boolean isValid(ArrayList<Crosser> Crossed ,ArrayList<Crosser>Waiting,ArrayList<Crosser>onBoat);
    public ArrayList<Crosser> getInitialCrossers();
    public String[] getInstructions();
            
}
