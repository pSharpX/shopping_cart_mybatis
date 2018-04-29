/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.busqueda.BusquedaProducto;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.mapper.ProductoMapper;

/**
 *
 * @author Java-LM
 */
public class MyBatisProductoRepositorioImpl 
        implements ProductoRepositorio {
    
    private ProductoMapper productoMapper;

    public MyBatisProductoRepositorioImpl(SqlSession session) {
        productoMapper = session.getMapper(ProductoMapper.class);
    }

    @Override
    public Producto buscar(Long id) {
        return productoMapper.selectProducto(id);
    }

    @Override
    public List<Producto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtenerPorCategoria(Long idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> obtenerPorCategoriaCriteriaApi(Long idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear(Producto producto) {
        productoMapper.insertProducto(producto);
    }

    @Override
    public List<Producto> obtenerProductosUltimoMes(BusquedaProducto busquedaProducto) {
        if(busquedaProducto.getIdCategoria() != null && busquedaProducto.getIdCategoria() <= 0)
            busquedaProducto.setIdCategoria(null);
        return productoMapper.selectProductosUltimoMes(busquedaProducto);
    }

    @Override
    public List<Producto> obtenerProductosUltimoMesProcedure(BusquedaProducto busquedaProducto) {
        if(busquedaProducto.getIdCategoria() != null && busquedaProducto.getIdCategoria() <= 0)
            busquedaProducto.setIdCategoria(null);
        return productoMapper.selectProductosUltimoMesProcedure(busquedaProducto);
    }
    
}
