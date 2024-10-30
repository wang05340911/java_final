package menu_factory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import components.Dessert;
import components.Drink;
import components.MainCourse;
import components.Entree;
/**
 *
 * @author gouraya
 */
public interface RestaurantMenuFactory {
    
    public Drink createDrink();
    public MainCourse createMainCourse();
    public Entree createEntree();
    public Dessert createDessert();
    
}
