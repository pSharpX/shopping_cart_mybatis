package pe.edu.cibertec.repositorio;

import java.util.List;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.busqueda.BusquedaProducto;

public interface ProductoRepositorio {

    Producto buscar(Long id);
    List<Producto> obtenerTodos();
    List<Producto> obtenerPorCategoria(Long idCategoria);
    List<Producto> obtenerPorCategoriaCriteriaApi(Long idCategoria);
    List<Producto> obtenerProductosUltimoMes(BusquedaProducto producto);
    List<Producto> obtenerProductosUltimoMesProcedure(BusquedaProducto busquedaProducto);
    void crear(Producto producto);
}
