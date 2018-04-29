package pe.edu.cibertec.repositorio;

import pe.edu.cibertec.dominio.Usuario;

public interface UsuarioRepositorio {

    Usuario buscar(Long id);
    void crear(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(Usuario usuario);
    Usuario buscar(String nombre);

    default void eliminar(Long id) {
        eliminar(buscar(id));
    }
}
