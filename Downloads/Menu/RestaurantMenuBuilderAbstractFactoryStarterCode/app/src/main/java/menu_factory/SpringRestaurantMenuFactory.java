/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author gouraya
 */
public class SpringRestaurantMenuFactory implements RestaurantMenuFactory {

     @Override
    public Drink createDrink() {
        // Add the required code here
        String drink = "Drink:\n"+ "Cucumber Smash\n"+"Lime Juice\n"+"Candy Apple Cider\n";
        System.out.println(drink);
        
        return new SpringDrink();
        
       
    }
    
    @Override
    public MainCourse createMainCourse() {
        // Add the required code here
         String main = "Main Courses:\n"+ "Sunny Rise Burger\n"+"California Spring Salad\n"+"Crispy Chicken\n"+"Sandwich\n";
        System.out.println(main);
         return new SpringMainCourse();
    }

    @Override    
    public Entree createEntree() {
        // Add the required code here
        String entree = "Entrees:\n"+ "Lobster Veracruzana\n"+"Organic Ocean Halibut\n"+"Mushroom Soup\n";
        System.out.println(entree);
         return new SpringEntree();
    }

    @Override    
    public Dessert createDessert() {
        // Add the required code here
        String dessert = "Desserts:\n"+ "Vanilla Crème Brûlée\n"+"White Chocolate\n"+"Brownie" + "Passion Fruit Fig Tar\n";
        System.out.println(dessert);
        return new SpringDessert();
    }    
}
