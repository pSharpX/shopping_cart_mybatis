package pe.edu.cibertec.dominio;

import pe.edu.cibertec.dominio.base.EntidadBase;

public class Categoria extends EntidadBase {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("{'id': %s, 'nombre': %s}", id, nombre);
    }    
}
