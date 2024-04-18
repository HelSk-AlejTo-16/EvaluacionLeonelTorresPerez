package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Producto;
/*
 * Clase repositorio o dao, utilizare la 
 * anotacion @Repository
 */

@Repository
public class ProductoDaoImpl implements IStudentDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> list() {
        return em.createQuery("from Producto").getResultList();
    }

    @Override
    public void save(Producto producto) {
        System.out.println("Producto id="+producto.getId());
        if(producto.getId() != null && producto.getId() >0){
            //Actualizo estudiante
            em.merge(producto);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(producto);
        }
    }

    @Override
    public Producto getById(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void delete(Long id) {
        Producto Producto = getById(id);
        em.remove(Producto);
    }

    
}