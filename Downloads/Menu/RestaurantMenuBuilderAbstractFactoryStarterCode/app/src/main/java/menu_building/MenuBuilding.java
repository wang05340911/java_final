
package menu_building;
import menus.*;

/**
 *The class defines framework for creating seasonal restaurant menus. Subclass
 * of MenuBuilding must implement the makeMenuBuilding method to provide the 
 * specific logic for constructing a menu based on a given season.
 * 
 */

public abstract class MenuBuilding {

    /**
     * Creates a restaurant menu based on the specified season.
     * This method is implemented by subclasses to handle the specific
     * construction of the seasonal menu.
     *
     * @param season the season for which the menu is to be created
    */
    
    protected abstract RestaurantMenu makeMenuBuilding(String season);

    /**
     * Builds and populates a restaurant menu for the given season.
     * This method calls makeMenuBuilding to create the menu
     * and then populates it with seasonal items.
     *
     * @param season the season for which the menu is to be created
     * @return a populated RestaurantMenu instance for the specified season
     */
    public RestaurantMenu buildRestaurantMenu(String season) {
        RestaurantMenu theMenu = makeMenuBuilding(season);
        theMenu.populateMenu();
        return theMenu;
    }
    
}