/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findById", query = "SELECT p FROM Pacientes p WHERE p.id = :id"),
    @NamedQuery(name = "Pacientes.findByNombre", query = "SELECT p FROM Pacientes p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pacientes.findByApellido", query = "SELECT p FROM Pacientes p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Pacientes.findByGSanguineo", query = "SELECT p FROM Pacientes p WHERE p.gSanguineo = :gSanguineo"),
    @NamedQuery(name = "Pacientes.findByAlergias", query = "SELECT p FROM Pacientes p WHERE p.alergias = :alergias"),
    @NamedQuery(name = "Pacientes.findByDni", query = "SELECT p FROM Pacientes p WHERE p.dni = :dni")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 4)
    @Column(name = "G_SANGUINEO")
    private String gSanguineo;
    @Size(max = 100)
    @Column(name = "ALERGIAS")
    private String alergias;
    @Column(name = "DNI")
    private Integer dni;
    @OneToMany(mappedBy = "idPaciente")
    private Collection<Pacientemedico> pacientemedicoCollection;
    @OneToMany(mappedBy = "idPacientes")
    private Collection<Historial> historialCollection;

    public Pacientes() {
    }

    public Pacientes(Integer id, String nombre, String apellido, String gSanguineo, String alergias, Integer dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.gSanguineo = gSanguineo;
        this.alergias = alergias;
        this.dni = dni;
    }

    public Pacientes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGSanguineo() {
        return gSanguineo;
    }

    public void setGSanguineo(String gSanguineo) {
        this.gSanguineo = gSanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @XmlTransient
    public Collection<Pacientemedico> getPacientemedicoCollection() {
        return pacientemedicoCollection;
    }

    public void setPacientemedicoCollection(Collection<Pacientemedico> pacientemedicoCollection) {
        this.pacientemedicoCollection = pacientemedicoCollection;
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
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Pacientes[ id=" + id + " ]";
    }
    
}
