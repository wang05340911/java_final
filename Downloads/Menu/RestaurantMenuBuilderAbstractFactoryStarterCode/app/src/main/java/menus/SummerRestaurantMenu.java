
package menus;

import menu_factory.RestaurantMenuFactory;

/**
 * This class represents a summer-themed menu. This class uses a RestaurantMenuFactory
 * to create and populate the menu with summer-specific items, including entrees, main courses, 
 * desserts, and drinks.
 * 
 */
public class SummerRestaurantMenu extends RestaurantMenu {
    
      RestaurantMenuFactory theFactory;
    
    public SummerRestaurantMenu(RestaurantMenuFactory factory) {
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
