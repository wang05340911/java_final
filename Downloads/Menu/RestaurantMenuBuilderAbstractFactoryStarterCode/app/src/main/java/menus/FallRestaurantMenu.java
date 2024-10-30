
package menus;
import menu_building.ConcreteMenuBuilding;
import menu_factory.RestaurantMenuFactory;

/**
 *This class represents a fall-themed menu.his class uses a RestaurantMenuFactory
 * to create and populate the menu with fall-specific items, including entrees, main courses, 
 * desserts, and drinks.
 *
 */
public class FallRestaurantMenu extends RestaurantMenu {
    
    RestaurantMenuFactory theFactory;                   //factory used to create fall menu
    
    /**
     * Constructs fall menu using specified factory which will be used to generate
     * all menu items for fall season.
     * @param factory 
     */
    public FallRestaurantMenu(RestaurantMenuFactory factory) {
        this.theFactory = factory;
    }
    
    /**
     * 
     * Populates the fall restaurant menu with seasonal items. This method 
     * adds entrees, main courses, desserts, and drinks to the menu using 
     * the specified factory.
     */
    @Override
    public void populateMenu() {
        System.out.println("Adding items to " + getName()+ "\n");
        System.out.println("The " + getName());
        System.out.println("Active:" + getPeriod()+"\n");
               
        theFactory.createEntree();
        theFactory.createMainCourse();
        theFactory.createDessert();
        theFactory.createDrink();
        
    }
}
