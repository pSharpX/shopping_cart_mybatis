package pe.edu.cibertec.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import pe.edu.cibertec.dominio.base.EntidadBase;

public class Carrito extends EntidadBase {

    private BigDecimal total;
    private Date fechaCreacion;
    private Date fechaCompra;
    private String direccionEnvio;
    private boolean activo;
    private List<DetalleCarrito> detalleCarritoList;
    private Usuario usuario;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<DetalleCarrito> getDetalleCarritoList() {
        return detalleCarritoList;
    }

    public void setDetalleCarritoList(List<DetalleCarrito> detalleCarritoList) {
        this.detalleCarritoList = detalleCarritoList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
