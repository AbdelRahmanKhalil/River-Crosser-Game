/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

import java.awt.geom.Point2D;
import javafx.scene.Node;

/**
 *
 * @author Lenovo
 */
public class Crosser extends GameObject implements ICrosser{

    private int Speed;
    private int Weight;
    private int EatingRank;
    private boolean Crossed;
    private boolean OnBoat;
    private String Name;
    private boolean canSail;
    public Crosser(Node Appearance,int Weight,String Name,boolean sail)
    {
        this.Appearance=Appearance;
        this.Weight=Weight;
        this.Name=Name;
        Speed=10-(this.Weight/10);
        this.canSail=sail;
    }
    public Crosser()
    {
        
    }

    /**
     * @return the Appearance
     */
    public Node getAppearance() {
        return Appearance;
    }

    /**
     * @param Appearance the Appearance to set
     */
    public void setAppearance(Node Appearance) {
        this.Appearance = Appearance;
    }

    /**
     * @return the Speed
     */
    public int getSpeed() {
        return Speed;
    }

    /**
     * @param Speed the Speed to set
     */
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    /**
     * @return the Weight
     */
    public int getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    /**
     * @return the Crossed
     */
    public boolean isCrossed() {
        return Crossed;
    }

    /**
     * @param Crossed the Crossed to set
     */
    public void setCrossed(boolean Crossed) {
        this.Crossed = Crossed;
    }

    /**
     * @return the OnBoat
     */
    public boolean isOnBoat() {
        return OnBoat;
    }

    /**
     * @param OnBoat the OnBoat to set
     */
    public void setOnBoat(boolean OnBoat) {
        this.OnBoat = OnBoat;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    public void moveUp()
    {
        Appearance.setLayoutY(Appearance.getLayoutY()-10);
    }
    public void moveDown()
    {
        Appearance.setLayoutY(Appearance.getLayoutY()+10);
    }
    public void moveLeft()
    {
        Appearance.setLayoutX(Appearance.getLayoutX()-10);
    }
    public void moveRight()
    {
        Appearance.setLayoutX(Appearance.getLayoutX()+10);
    }
    public boolean isColliding(Boat b)
    {
        return getAppearance().getBoundsInParent().intersects(b.Appearance.getBoundsInParent());
        
    }

    @Override
    public boolean canSail() {
       return canSail;
    }

    @Override
    public int getEatingRank() {
     return EatingRank;
    }

  
    public Crosser makeCopy() {
     return this;     
    }

    
    public void setLabelToBeShown(String label) {
        
    }

    @Override
    public String getLabelToBeShown() {
    return null;
    }
    
}
