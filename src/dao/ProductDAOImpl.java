package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import entities.Product;

public class ProductDAOImpl implements ProductDAO {

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

        //The query can be found in the entity class.
        Query query = em.createNamedQuery("getByName", Product.class);
        query.setParameter("name", "%" + name + "%");
        List<Product> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Product> getByPriceRange(double min, double max) {
        EntityManager em = emf.createEntityManager();

        //The query can be found in the entity class.
        Query q = em.createNamedQuery("getByPriceRange", Product.class);
        q.setParameter("min", min);
        q.setParameter("max", max);
        List<Product> list = q.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Product> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Product> list = em.createNamedQuery("getAll").getResultList();
        em.close();
        return list;
    }

    @Override
    public void updatePrice(int id, double newPrice) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product p = em.find(Product.class, id);
        if (p != null) {
            p.setPrice(newPrice);
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("Product was not found");
        }

    }

    @Override
    public void remove(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product a = em.find(Product.class, id);

        if (a != null) {
            em.remove(a);
            em.getTransaction().commit();
            em.close();

        } else {
            System.out.println("The product doesn't exist");

        }

    }

    @Override
    public void updateName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product a = em.find(Product.class, id);
        if (a != null) {
            a.setName(name);
            em.getTransaction().commit();
            em.close();

        } else {
            System.out.println("Not possible");

        }

    }

}
