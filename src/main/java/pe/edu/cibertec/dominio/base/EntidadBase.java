package pe.edu.cibertec.dominio.base;

import java.io.Serializable;

public abstract class EntidadBase implements Serializable {

    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
