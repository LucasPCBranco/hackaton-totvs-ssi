/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.previtale.service.bd.amazon.entities;

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
 * @author juan_
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva")
    , @NamedQuery(name = "Reserva.findByData", query = "SELECT r FROM Reserva r WHERE r.data = :data")
    , @NamedQuery(name = "Reserva.findByConflitoReserva", query = "SELECT r FROM Reserva r WHERE r.conflitoReserva = :conflitoReserva")
    , @NamedQuery(name = "Reserva.findByMotivo", query = "SELECT r FROM Reserva r WHERE r.motivo = :motivo")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreserva")
    private Integer idreserva;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "conflito_reserva")
    private Short conflitoReserva;
    @Size(max = 200)
    @Column(name = "motivo")
    private String motivo;
    @JoinColumn(name = "praca_esportiva_praca_esportivaId", referencedColumnName = "praca_esportivaId")
    @ManyToOne(optional = false)
    private PracaEsportiva pracaesportivapracaesportivaId;
    @JoinColumn(name = "time_idtime", referencedColumnName = "idtime")
    @ManyToOne(optional = false)
    private Time timeIdtime;

    public Reserva() {
    }

    public Reserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Short getConflitoReserva() {
        return conflitoReserva;
    }

    public void setConflitoReserva(Short conflitoReserva) {
        this.conflitoReserva = conflitoReserva;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public PracaEsportiva getPracaesportivapracaesportivaId() {
        return pracaesportivapracaesportivaId;
    }

    public void setPracaesportivapracaesportivaId(PracaEsportiva pracaesportivapracaesportivaId) {
        this.pracaesportivapracaesportivaId = pracaesportivapracaesportivaId;
    }

    public Time getTimeIdtime() {
        return timeIdtime;
    }

    public void setTimeIdtime(Time timeIdtime) {
        this.timeIdtime = timeIdtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.previtale.service.bd.amazon.entities.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
