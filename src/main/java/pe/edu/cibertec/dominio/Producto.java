package pe.edu.cibertec.dominio;

import java.math.BigDecimal;
import pe.edu.cibertec.dominio.base.EntidadBase;

public class Producto extends EntidadBase {

    public static final String NQ_OBTENER_PRODUCTO_POR_CATEGORIA = "nq_obtener_producto_por_categoria";

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private byte[] imagen;
    private Categoria categoria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("{'id': %d, 'nombre': %s, 'categoria': %s}", id, nombre, categoria.getNombre());
    }
    
}
