package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.Producto;

import java.util.List;

public interface IStudentService {
    List<Producto> list();
    void save(Producto producto);
    Producto getById(Long id);
    void delete(Long id);
}
