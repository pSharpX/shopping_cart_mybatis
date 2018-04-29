/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.repositorio.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import pe.edu.cibertec.dominio.Categoria;

/**
 *
 * @author Java-LM
 */
public interface CategoriaMapper {
    
    @Select("SELECT id, nombre from categoria")
    List<Categoria> obtenerTodos();
    
}
