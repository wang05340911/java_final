/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author gouraya
 */
public class SummerRestaurantMenuFactory implements RestaurantMenuFactory {
   
   @Override
    public Drink createDrink() {
        // Add the required code here
        String drink = "Drink:\n"+ "Lemonade\n"+"Sangria\n"+"Rum Punch\n";
        System.out.println(drink);
        
        return new SummerDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        // Add the required code here
         String main = "Main Courses:\n"+ "Beef Tartare\n"+"Spiced Cauliflower\n" + "Chinook Salmon\n";
        System.out.println(main);
         return new SummerMainCourse();
    }

    @Override    
    public Entree createEntree() {
        // Add the required code here
        String entree = "Entrees:\n"+ "Avocado Scramble\n"+"Little Gem Salad\n"+"Miso Cauliflower Soup\n";
        System.out.println(entree);
         return new SummerEntree();
    }

    @Override    
    public Dessert createDessert() {
        // Add the required code here
        String dessert = "Desserts:\n"+ "Lime Pie\n"+"Ultimate Cookie\n";
        System.out.println(dessert);
        return new SummerDessert();
    }    
}
