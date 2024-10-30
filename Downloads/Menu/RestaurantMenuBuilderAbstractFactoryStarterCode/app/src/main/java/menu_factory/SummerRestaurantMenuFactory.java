
package menu_factory;
import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
import components.SummerDessert;
import components.SummerDrink;
import components.SummerEntree;
import components.SummerMainCourse;


/**
 *This class provide summer-themed menu items, including drinks, main courses, entrees, 
 * and desserts. Each method in this factory returns a specific item for the summer season 
 * and displays a sample list of summer-themed options.
 * 
 */
public class SummerRestaurantMenuFactory implements RestaurantMenuFactory {
   
   @Override
    public Drink createDrink() {
        
        String drink = "Drink:\n"+ "Lemonade\n"+"Sangria\n"+"Rum Punch\n";
        System.out.println(drink);
        
        return new SummerDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        
         String main = "Main Courses:\n"+ "Beef Tartare\n"+"Spiced Cauliflower\n" + "Chinook Salmon\n";
        System.out.println(main);
         return new SummerMainCourse();
    }

    @Override    
    public Entree createEntree() {
        
        String entree = "Entrees:\n"+ "Avocado Scramble\n"+"Little Gem Salad\n"+"Miso Cauliflower Soup\n";
        System.out.println(entree);
         return new SummerEntree();
    }

    @Override    
    public Dessert createDessert() {
        
        String dessert = "Desserts:\n"+ "Lime Pie\n"+"Ultimate Cookie\n";
        System.out.println(dessert);
        return new SummerDessert();
    }    
}
