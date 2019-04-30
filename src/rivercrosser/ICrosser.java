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
public interface ICrosser {
    public boolean canSail() ;
    public int getWeight() ;
    public int getEatingRank();

 
    public Crosser makeCopy();
  

   
    public void setLabelToBeShown(String label);
     
    public String getLabelToBeShown();
    
}
