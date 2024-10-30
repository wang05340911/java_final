
package menu_building;
import menu_factory.*;
import menus.*;

/**
 *The following class provides an implementation of creating restaurant menus 
 * based on the provided season. This class uses different factory instances
 * to create and configure menus specific to fall, winter, spring, and summer.
 * 
 */
public class ConcreteMenuBuilding extends MenuBuilding {
    
    @Override
    
    /**
     * Creates a seasonal menu based on the specified season.
     * This method selects the appropriate RestaurantMenuFactory
     * and RestaurantMenu subclasses, configuring them with 
     * a name and period specific to the season.
     *
     * @param season the season for which the menu is created; 
     *               expected values are "Fall", "Winter", "Spring", or "Summer"
     * @return a RestaurantMenu instance for the specified season
     */
    
    protected RestaurantMenu makeMenuBuilding(String season) {
        RestaurantMenu theMenu = null;
        if ("Fall".equalsIgnoreCase(season)) {
            RestaurantMenuFactory theFactory = new FallRestaurantMenuFactory();
            theMenu = new FallRestaurantMenu(theFactory);
            theMenu.setName("Fall Menu");
            theMenu.setPeriod("September 1 to November 30.");
        }
        else if ("Winter".equalsIgnoreCase(season)) {
            RestaurantMenuFactory theFactory = new WinterRestaurantMenuFactory();
            theMenu = new WinterRestaurantMenu(theFactory);
            theMenu.setName("Winter Menu"); 
            theMenu.setPeriod("December 1 to February 28.");
        }
        else if ("Spring".equalsIgnoreCase(season)) {
            RestaurantMenuFactory theFactory = new SpringRestaurantMenuFactory();
            theMenu = new SpringRestaurantMenu(theFactory);
            theMenu.setName("Spring Menu");
            theMenu.setPeriod("March 1 to May 30.");
        }
        else if ("Summer".equalsIgnoreCase(season)) {
            RestaurantMenuFactory theFactory = new SummerRestaurantMenuFactory();
            theMenu = new SummerRestaurantMenu(theFactory);
            theMenu.setName("Summer Menu");
            theMenu.setPeriod("June 1 to August 31");
        }
        return theMenu;
    }
    
}
