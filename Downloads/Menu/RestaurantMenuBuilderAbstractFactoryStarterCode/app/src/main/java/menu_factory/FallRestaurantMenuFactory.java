/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author gouraya
 */
public class FallRestaurantMenuFactory implements RestaurantMenuFactory {

    @Override
    public Drink createDrink() {
        // Add the required code here
        String drink = "Drink:\n"+ "Margarita\n"+"Dark Rum\n"+"Orange Juice\n";
        System.out.println(drink);
        
        return new FallDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        // Add the required code here
         String main = "Main Courses:\n"+ "Salmon Avocado Toast\n"+"Pesto Chicken Penne Asiago\n"+"Portobello Mushroom Chicken\n";
        System.out.println(main);
         return new FallMainCourse();
    }

    @Override    
    public Entree createEntree() {
        // Add the required code here
        String entree = "Entrees:\n"+ "Spinach and Artichoke Dip\n"+"Sesame Soy Tuna Tartare\n"+"Tuscan Bruschetta\n";
        System.out.println(entree);
         return new FallEntree();
    }

    @Override    
    public Dessert createDessert() {
        // Add the required code here
        String dessert = "Desserts:\n"+ "Carrot Cake\n"+"White Chocolate Cheesecake\n"+"Apple Pie\n";
        System.out.println(dessert);
        return new FallDessert();
    }    
}
