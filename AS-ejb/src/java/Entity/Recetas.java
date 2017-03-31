/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "RECETAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recetas.findAll", query = "SELECT r FROM Recetas r"),
    @NamedQuery(name = "Recetas.findById", query = "SELECT r FROM Recetas r WHERE r.id = :id"),
    @NamedQuery(name = "Recetas.findByInicio", query = "SELECT r FROM Recetas r WHERE r.inicio = :inicio"),
    @NamedQuery(name = "Recetas.findByFin", query = "SELECT r FROM Recetas r WHERE r.fin = :fin"),
    @NamedQuery(name = "Recetas.findByMedicinas", query = "SELECT r FROM Recetas r WHERE r.medicinas = :medicinas"),
    @NamedQuery(name = "Recetas.findByTomas", query = "SELECT r FROM Recetas r WHERE r.tomas = :tomas")})
public class Recetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INICIO")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "FIN")
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Size(max = 100)
    @Column(name = "MEDICINAS")
    private String medicinas;
    @Column(name = "TOMAS")
    private Integer tomas;
    @OneToMany(mappedBy = "idRecetas")
    private Collection<Historial> historialCollection;

    public Recetas() {
    }

    public Recetas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getMedicinas() {
        return medicinas;
    }

    public void setMedicinas(String medicinas) {
        this.medicinas = medicinas;
    }

    public Integer getTomas() {
        return tomas;
    }

    public void setTomas(Integer tomas) {
        this.tomas = tomas;
    }

    @XmlTransient
    public Collection<Historial> getHistorialCollection() {
        return historialCollection;
    }

    public void setHistorialCollection(Collection<Historial> historialCollection) {
        this.historialCollection = historialCollection;
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
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Recetas[ id=" + id + " ]";
    }
    
}
