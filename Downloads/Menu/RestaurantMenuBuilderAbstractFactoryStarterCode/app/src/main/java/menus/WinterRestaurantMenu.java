/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import menu_factory.RestaurantMenuFactory;

/**
 *
 * @author gouraya
 */
public class WinterRestaurantMenu extends RestaurantMenu {
    
    RestaurantMenuFactory theFactory;
    
    public WinterRestaurantMenu(RestaurantMenuFactory factory) {
        this.theFactory = factory;
    }
    
    @Override
    public void populateMenu() {
        System.out.println("Adding items to " + getName() + "\n");
        System.out.println("The " + getName());
        System.out.println("Active:" + getPeriod()+"\n");
        
        // Insert code to assign menu items created
        theFactory.createEntree();
        theFactory.createMainCourse();
        theFactory.createDessert();
        theFactory.createDrink();
    }
    
}
