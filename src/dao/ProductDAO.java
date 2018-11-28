package dao;

import java.util.List;
import entities.Product;

public interface ProductDAO {

    //creates a object. 
    void create(String name, double price);

    List<Product> getByName(String name);
// returns all product with the exact name

    List<Product> getByPriceRange(double min, double max);
// returns all products within the price 

    List<Product> getAll();
//returns all products

    boolean updatePrice(int id, double newPrice);
// set a new price for the product, return success/failure

    boolean updateName (int id, String name);
    //set a new name.
    boolean remove(int id);
// removes the product, return success/failure 
}
