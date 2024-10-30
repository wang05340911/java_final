
package menus;
import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;

/**
 *This  class defines the common structure 
 * for a restaurant menu, including properties such as the menu's name, 
 * the active period, and menu items like entree, main course, dessert, 
 * and drink. This class provides methods to get and set the name and period, 
 * as well as an abstract method to populate the menu.
 */
public abstract class RestaurantMenu {
    
    private String name; // Menu name
    private String period; // Period during which the menu is active
    
    // Newly defined objects that represent the menu items.
    protected Entree entree;
    protected MainCourse mainCourse;
    protected Dessert dessert;
    protected Drink drink;
    
    /**
     * Gets the name of the menu.
     *
     * @return the name of the menu
     */
    
    public String getName() {
        
        return name;
    }
    
     /**
     * Sets the name of the menu.
     *
     * @param name the name to set for the menu
     */
    public void setName(String name) {
        
        this.name = name;
        
    }
    
    /**
     * Gets the period during which the menu is active.
     *
     * @return the active period of the menu
     */
    public String getPeriod() {
       
        return period;
    }
    
    /**
     * Sets the active period of the menu.
     *
     * @param p the period to set for the menu
     */
    public void setPeriod(String p) {
        
        this.period = p ;
        
    }
    
    /**
     * Populates the menu with items. This method should be implemented by 
     * subclasses to define how menu items are created and assigned.
     */
    public abstract void populateMenu();
    
  
    /**
     * Returns a string representation of the menu.
     *
     * @return a string representation of the menu
     */
    @Override
    public String toString() {
        return "";
    }
    
    
}
