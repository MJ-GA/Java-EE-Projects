/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.joui0005.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 16138
 */
@Entity
@Table(name = "SPRITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprite.findAll", query = "SELECT s FROM Sprite s"),
    @NamedQuery(name = "Sprite.findById", query = "SELECT s FROM Sprite s WHERE s.id = :id"),
    @NamedQuery(name = "Sprite.findByXspeed", query = "SELECT s FROM Sprite s WHERE s.xspeed = :xspeed"),
    @NamedQuery(name = "Sprite.findByXvalue", query = "SELECT s FROM Sprite s WHERE s.xvalue = :xvalue"),
    @NamedQuery(name = "Sprite.findByYspeed", query = "SELECT s FROM Sprite s WHERE s.yspeed = :yspeed"),
    @NamedQuery(name = "Sprite.findByYvalue", query = "SELECT s FROM Sprite s WHERE s.yvalue = :yvalue")})
public class Sprite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "XSPEED")
    private Integer xspeed;
    @Column(name = "XVALUE")
    private Integer xvalue;
    @Column(name = "YSPEED")
    private Integer yspeed;
    @Column(name = "YVALUE")
    private Integer yvalue;
    @JoinTable(name = "SPRITE_SPRITE", joinColumns = {
        @JoinColumn(name = "SPRITE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "LISTOFSPRITES_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Sprite> spriteCollection;
    @ManyToMany(mappedBy = "spriteCollection")
    private Collection<Sprite> spriteCollection1;

    public Sprite() {
    }

    public Sprite(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getXspeed() {
        return xspeed;
    }

    public void setXspeed(Integer xspeed) {
        this.xspeed = xspeed;
    }

    public Integer getXvalue() {
        return xvalue;
    }

    public void setXvalue(Integer xvalue) {
        this.xvalue = xvalue;
    }

    public Integer getYspeed() {
        return yspeed;
    }

    public void setYspeed(Integer yspeed) {
        this.yspeed = yspeed;
    }

    public Integer getYvalue() {
        return yvalue;
    }

    public void setYvalue(Integer yvalue) {
        this.yvalue = yvalue;
    }

    @XmlTransient
    public Collection<Sprite> getSpriteCollection() {
        return spriteCollection;
    }

    public void setSpriteCollection(Collection<Sprite> spriteCollection) {
        this.spriteCollection = spriteCollection;
    }

    @XmlTransient
    public Collection<Sprite> getSpriteCollection1() {
        return spriteCollection1;
    }

    public void setSpriteCollection1(Collection<Sprite> spriteCollection1) {
        this.spriteCollection1 = spriteCollection1;
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
        if (!(object instanceof Sprite)) {
            return false;
        }
        Sprite other = (Sprite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cst8218.joui0005.entity.Sprite[ id=" + id + " ]";
    }
    
}
