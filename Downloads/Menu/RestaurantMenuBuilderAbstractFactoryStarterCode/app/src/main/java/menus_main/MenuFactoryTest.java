
package menus_main;
import menu_building.*;
import menus.*;

/**
 *This class creates and displays seasonal restaurant menus using factory design 
 * pattern. It initializes a ConcreteMenuBuilding instance to generate menus for 
 * each season and prints out the resulting menus.
 * 
 */
public class MenuFactoryTest {

    /**
     * The main method serves as the entry point for testing the seasonal 
     * menu generation. It creates a ConcreteMenuBuilding instance 
     * and uses it to generate and display menus for Fall, Winter, Spring, 
     * and Summer seasons.
     *
     * @param args command-line arguments (not used)
     */
public static void main(String[] args) {
        
        MenuBuilding theBuilding = new ConcreteMenuBuilding();                  //menu-building instance to create seasonal menus
        
        RestaurantMenu theFallMenu = theBuilding.buildRestaurantMenu("Fall");   //build and display fall menu
        System.out.println(theFallMenu);
        
        RestaurantMenu theWinterMenu = theBuilding.buildRestaurantMenu("Winter"); //build and display winter menu
        System.out.println(theWinterMenu);
        
        RestaurantMenu theSpringMenu = theBuilding.buildRestaurantMenu("Spring"); //build and display spring menu
        System.out.println(theSpringMenu );
         
        RestaurantMenu theSummerMenu = theBuilding.buildRestaurantMenu("Summer"); //build and display summer menu
        System.out.println(theSummerMenu);
        
    }    
}
