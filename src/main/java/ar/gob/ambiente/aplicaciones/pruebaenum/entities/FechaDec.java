

package ar.gob.ambiente.aplicaciones.pruebaenum.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rincostante
 */
@Entity
public class FechaDec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Campo que guarda la fecha específica
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column (nullable=false)
    @NotNull(message = "El campo fecha no puede ser nulo")    
    private Date fecha;    
    
    @Column (nullable=false)
    @NotNull(message = "El campo tipoFecha no puede ser nulo")
    @Enumerated(EnumType.STRING) 
    private TipoFecha tipoFecha;
    
    
    /**********************
     * Métodos de acceso **
     **********************/
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoFecha getTipoFecha() {
        return tipoFecha;
    }

    public void setTipoFecha(TipoFecha tipoFecha) {
        this.tipoFecha = tipoFecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechaDec)) {
            return false;
        }
        FechaDec other = (FechaDec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.aplicaciones.pruebaenum.entities.FechaDec[ id=" + id + " ]";
    }
    
}
