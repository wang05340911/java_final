
package menu_factory;
import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
import components.SpringDessert;
import components.SpringDrink;
import components.SpringEntree;
import components.SpringMainCourse;
;
/**
 *This class provide Spring-themed menu items, including drinks, main courses, entrees, 
 * and desserts. Each method in this factory returns a specific item for the spring season 
 * and displays a sample list of spring-themed options.
 * 
 */
public class SpringRestaurantMenuFactory implements RestaurantMenuFactory {

    
     @Override
    public Drink createDrink() {
        
        String drink = "Drink:\n"+ "Cucumber Smash\n"+"Lime Juice\n"+"Candy Apple Cider\n";
        System.out.println(drink);
        
        return new SpringDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        
         String main = "Main Courses:\n"+ "Sunny Rise Burger\n"+"California Spring Salad\n"+"Crispy Chicken\n"+"Sandwich\n";
        System.out.println(main);
         return new SpringMainCourse();
    }

    @Override    
    public Entree createEntree() {
       
        String entree = "Entrees:\n"+ "Lobster Veracruzana\n"+"Organic Ocean Halibut\n"+"Mushroom Soup\n";
        System.out.println(entree);
         return new SpringEntree();
    }

    @Override    
    public Dessert createDessert() {
        
        String dessert = "Desserts:\n"+ "Vanilla Crème Brûlée\n"+"White Chocolate\n"+"Brownie" + "Passion Fruit Fig Tar\n";
        System.out.println(dessert);
        return new SpringDessert();
    }    
}
