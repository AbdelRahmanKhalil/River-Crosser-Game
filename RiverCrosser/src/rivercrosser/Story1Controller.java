/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrosser;

/**
 *
 * @author Lenovo
 */
public class Story1Controller {
    
    Story1Model Model=new Story1Model();
    Story1View View=new Story1View();
    public Story1Controller()
    {
    }
    
     public Story1Controller(Story1View theView, Story1Model theModel) {
        this.View = theView;
        this.Model = theModel;
    }
}
