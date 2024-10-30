
package menus;

import menu_factory.RestaurantMenuFactory;

/**
 * THis class represents a spring-themed menu. This class uses a RestaurantMenuFactory
 * to create and populate the menu with spring-specific items, including entrees, main courses, 
 * desserts, and drinks.
 * 
 */
public class SpringRestaurantMenu extends RestaurantMenu {

    RestaurantMenuFactory theFactory;
    
    public SpringRestaurantMenu(RestaurantMenuFactory factory) {
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
