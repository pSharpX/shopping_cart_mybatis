package pe.edu.cibertec.repositorio;

import java.util.List;
import pe.edu.cibertec.dominio.Carrito;

public interface CarritoRepositorio {

    List<Carrito> buscarPorUsuario(Long idUsuario);
}
