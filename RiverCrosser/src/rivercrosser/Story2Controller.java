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
public class Story2Controller {
     Story2Model Model=new Story2Model();
    Story2View View=new Story2View();
    
     public Story2Controller() {
        
    }
     public Story2Controller(Story2View theView, Story2Model theModel) {
        this.View = theView;
        this.Model = theModel;
    }
}
