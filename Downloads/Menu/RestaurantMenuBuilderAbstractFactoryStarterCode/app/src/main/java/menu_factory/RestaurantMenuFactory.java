package menu_factory;

import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
/**
 * Provides a layout for creating various components of restaurant menu
 * i.e. drinks, dessert, main course, and entree. It enables the creation
 * of a family of related objects that make up a complete menu.
 * 
 */
public interface RestaurantMenuFactory {
    
    public Drink createDrink();
    public MainCourse createMainCourse();
    public Entree createEntree();
    public Dessert createDessert();
    
}
