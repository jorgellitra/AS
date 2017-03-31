/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "HISTORIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findById", query = "SELECT h FROM Historial h WHERE h.id = :id"),
    @NamedQuery(name = "Historial.findByFecha", query = "SELECT h FROM Historial h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "Historial.findBySintomas", query = "SELECT h FROM Historial h WHERE h.sintomas = :sintomas")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 200)
    @Column(name = "SINTOMAS")
    private String sintomas;
    @JoinColumn(name = "ID_RECETAS", referencedColumnName = "ID")
    @ManyToOne
    private Recetas idRecetas;
    @JoinColumn(name = "ID_PACIENTES", referencedColumnName = "ID")
    @ManyToOne
    private Pacientes idPacientes;
    @JoinColumn(name = "ID_PACIENTEMEDICO", referencedColumnName = "ID")
    @ManyToOne
    private Pacientemedico idPacientemedico;

    public Historial() {
    }

    public Historial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Recetas getIdRecetas() {
        return idRecetas;
    }

    public void setIdRecetas(Recetas idRecetas) {
        this.idRecetas = idRecetas;
    }

    public Pacientes getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Pacientes idPacientes) {
        this.idPacientes = idPacientes;
    }

    public Pacientemedico getIdPacientemedico() {
        return idPacientemedico;
    }

    public void setIdPacientemedico(Pacientemedico idPacientemedico) {
        this.idPacientemedico = idPacientemedico;
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
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Historial[ id=" + id + " ]";
    }
    
}
