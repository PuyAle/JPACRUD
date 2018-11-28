
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entities.Product;



public class ProductDAOImpl implements ProductDAO{
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        
    
    @Override
    public void create(String name, double price) {
        EntityManager em = emf.createEntityManager();
        
        Product p = new Product(name, price);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Product> getByName(String name) {
        EntityManager em = emf.createEntityManager();
       
        Query query = em.createNamedQuery("getByName", Product.class);
        query.setParameter("name", "%"+name+"%");
        List <Product>list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Product> getByPriceRange(double min, double max) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("getByPriceRange", Product.class);
        q.setParameter("min", min);
        q.setParameter("max", max);
        List <Product>list = q.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Product> getAll() {
        EntityManager em = emf.createEntityManager();
        List <Product>list = em.createNamedQuery("getAll").getResultList();
        em.close();
        return list;
    }

    @Override
    public boolean updatePrice(int id, double newPrice) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product p = em.find(Product.class, id);
        p.setPrice(newPrice);
        em.getTransaction().commit();
        em.close();
        return true; 
        
    }

    @Override
    public boolean remove(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product a = em.find(Product.class, id);
        em.remove(a);
        em.getTransaction().commit();
        em.close();
        return true; 
    }

    @Override
    public boolean updateName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product a = em.find(Product.class, id);
        a.setName(name);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    
}
