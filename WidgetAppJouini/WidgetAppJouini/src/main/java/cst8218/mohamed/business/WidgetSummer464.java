/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.mohamed.business;

import cst8218.mohamed.business.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author admin
 */
@Entity

@XmlRootElement
public class WidgetSummer464 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "nameS21joui")
    private String nameS21joui;
    @Column(name = "quantityS21joui")        
    private int quantityS21joui;
  

    public WidgetSummer464() {
    }

    public WidgetSummer464(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public String getnameS21joui() {
        return nameS21joui;
    }

    public void setnameS21joui(String nameS21joui) {
        this.nameS21joui = nameS21joui;
    }
    
     public int getquantityS21joui() {
        return quantityS21joui;
    }

    public void setId(int quantityS21joui) {
        this.quantityS21joui = quantityS21joui;
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
        if (!(object instanceof WidgetSummer464)) {
            return false;
        }
        WidgetSummer464 other = (WidgetSummer464) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.mohamed.widgetappjouini.WidgetSummer464[ id=" + id + " ]";
    }
    
}
