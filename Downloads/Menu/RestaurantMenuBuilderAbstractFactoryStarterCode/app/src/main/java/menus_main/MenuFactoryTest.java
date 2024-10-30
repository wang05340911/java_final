
package menus_main;
import menu_building.*;
import menus.*;

/**
 *
 * @author gouraya
 */
public class MenuFactoryTest {

public static void main(String[] args) {
        
        MenuBuilding theBuilding = new ConcreteMenuBuilding();
        
        RestaurantMenu theFallMenu = theBuilding.buildRestaurantMenu("Fall"); 
        System.out.println(theFallMenu);
        
        RestaurantMenu theWinterMenu = theBuilding.buildRestaurantMenu("Winter");
        System.out.println(theWinterMenu);
        
        RestaurantMenu theSpringMenu = theBuilding.buildRestaurantMenu("Spring");
        System.out.println(theSpringMenu );
         
        RestaurantMenu theSummerMenu = theBuilding.buildRestaurantMenu("Summer");
        System.out.println(theSummerMenu);
        
    }    
}
