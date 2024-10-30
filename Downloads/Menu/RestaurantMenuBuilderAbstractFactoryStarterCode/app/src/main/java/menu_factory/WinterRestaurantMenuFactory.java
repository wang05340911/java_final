
package menu_factory;
import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
import components.WinterDessert;
import components.WinterDrink;
import components.WinterEntree;
import components.WinterMainCourse;

/**
 *This class provide spring-themed menu items, including drinks, main courses, entrees, 
 * and desserts. Each method in this factory returns a specific item for the spring season 
 * and displays a sample list of spring-themed options.
 * 
 */
public class WinterRestaurantMenuFactory implements RestaurantMenuFactory {
    
     @Override
    public Drink createDrink() {
        // Add the required code here
        String drink = "Drink:\n"+ "Mojito\n"+"Alcohol Free Wine\n"+"Tequila\n";
        System.out.println(drink);
        
        return new WinterDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        // Add the required code here
         String main = "Main Courses:\n"+ "Sirloin\n"+ "Salmon Croquettes\n"+"Steak and Fries\n";
        System.out.println(main);
         return new WinterMainCourse();
    }

    @Override    
    public Entree createEntree() {
        // Add the required code here
        String entree = "Entrees:\n"+ "Sesame Soy Tartare\n"+"Boston Clam Chowder\n"+"Thai Soup\n";
        System.out.println(entree);
         return new WinterEntree();
    }

    @Override    
    public Dessert createDessert() {
        // Add the required code here
        String dessert = "Desserts:\n"+ "Vanilla Crème Brûlée\n"+"White Chocolate\n"+"Brownie" + "Passion Fruit Fig Tar\n";
        System.out.println(dessert);
        return new WinterDessert();
    }    
}
