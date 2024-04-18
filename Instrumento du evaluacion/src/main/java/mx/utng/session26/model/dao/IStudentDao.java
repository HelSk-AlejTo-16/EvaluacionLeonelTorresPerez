package mx.utng.session26.model.dao;

import java.util.List;

import mx.utng.session26.model.entity.Producto;


public interface IStudentDao {
    List<Producto> list();
    void save(Producto producto);
    Producto getById(Long id);
    void delete(Long id);
}
