
package menus;

import menu_factory.RestaurantMenuFactory;

/**
 * This class represents a winter-themed menu. This class uses a RestaurantMenuFactory
 * to create and populate the menu with winter-specific items, including entrees, main courses, 
 * desserts, and drinks.
 * 
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
        
        
        theFactory.createEntree();
        theFactory.createMainCourse();
        theFactory.createDessert();
        theFactory.createDrink();
    }
    
}
