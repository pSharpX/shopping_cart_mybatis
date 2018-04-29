/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio.mapper;

import java.util.List;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.busqueda.BusquedaProducto;

/**
 *
 * @author Java-LM
 */
public interface ProductoMapper {
    Producto selectProducto(Long id);
    void insertProducto(Producto producto);
    List<Producto> selectProductosUltimoMes(BusquedaProducto busquedaProducto);
    List<Producto> selectProductosUltimoMesProcedure(BusquedaProducto busquedaProducto);    
}
