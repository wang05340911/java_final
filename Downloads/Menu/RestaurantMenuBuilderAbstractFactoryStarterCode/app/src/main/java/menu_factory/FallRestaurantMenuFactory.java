
package menu_factory;
import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
import components.FallDessert;
import components.FallDrink;
import components.FallEntree;
import components.FallMainCourse;

/**
 *This class provide fall-themed menu items, including drinks, main courses, entrees, 
 * and desserts. Each method in this factory returns a specific item for the fall season 
 * and displays a sample list of fall-themed options.
 * 
 */
public class FallRestaurantMenuFactory implements RestaurantMenuFactory {

    /**
     * Creates and return fall drink
     * @return  FallDrink instance
     */
    @Override
    public Drink createDrink() {
        // Add the required code here
        String drink = "Drink:\n"+ "Margarita\n"+"Dark Rum\n"+"Orange Juice\n";
        System.out.println(drink);
        
        return new FallDrink();
        
       
    }
    
    /**
     * Creates and return fall main course
     * @return  FallMainCourse instance
     */
    @Override
    public MainCourse createMainCourse() {
        // Add the required code here
         String main = "Main Courses:\n"+ "Salmon Avocado Toast\n"+"Pesto Chicken Penne Asiago\n"+"Portobello Mushroom Chicken\n";
        System.out.println(main);
         return new FallMainCourse();
    }

    /**
     * Creates and return fall entree
     * @return  FallEntree instance
     */
    @Override    
    public Entree createEntree() {
        // Add the required code here
        String entree = "Entrees:\n"+ "Spinach and Artichoke Dip\n"+"Sesame Soy Tuna Tartare\n"+"Tuscan Bruschetta\n";
        System.out.println(entree);
         return new FallEntree();
    }

    /**
     * Creates and return fall desset
     * @return  FallDessert instance
     */
    @Override    
    public Dessert createDessert() {
        // Add the required code here
        String dessert = "Desserts:\n"+ "Carrot Cake\n"+"White Chocolate Cheesecake\n"+"Apple Pie\n";
        System.out.println(dessert);
        return new FallDessert();
    }    
}
