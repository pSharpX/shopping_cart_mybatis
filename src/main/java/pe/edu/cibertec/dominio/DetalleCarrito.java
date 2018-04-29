package pe.edu.cibertec.dominio;

import java.math.BigDecimal;
import pe.edu.cibertec.dominio.base.EntidadBase;

public class DetalleCarrito extends EntidadBase {

    private Carrito carritoCompras;

    private Producto producto;

    private int cantidad;
    private BigDecimal precioUnitario;

    public Carrito getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(Carrito carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
