/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intiformation.gestioncargaison.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author IN-MP-007
 */
@Entity(name = "cargaison")
@Table(name = "cargaisons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_cargaison", discriminatorType = DiscriminatorType.STRING)
@XmlRootElement
public class Cargaison implements Serializable{
    
    /*=======================================================================*/
    /*======================== Attributs ====================================*/
    /*=======================================================================*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargaison")
    private int reference;
    @Column(name = "distance")
    private long distance;
    @Column(name = "date_livraison")
    @Temporal(value = TemporalType.DATE)
    private Date date_livraison;

    /*========================================================================*/
    /*================ association avec la classe Marchandises ===============*/
    /*========================================================================*/
    
    @OneToMany(mappedBy = "cargaison", cascade = CascadeType.ALL)
    private List<Marchandises> marchandises;

    public List<Marchandises> getMarchandises() {
        return marchandises;
    }

    public void setMarchandises(List<Marchandises> marchandises) {
        this.marchandises = marchandises;
    }
    
     
    /*========================================================================*/
    /*========================== Constructeurs ===============================*/
    /*========================================================================*/
    public Cargaison() {
    }

    public Cargaison(int reference, long distance, Date date_livraison) {
        this.reference = reference;
        this.distance = distance;
        this.date_livraison = date_livraison;
    }

    public Cargaison(long distance, Date date_livraison) {
        this.distance = distance;
        this.date_livraison = date_livraison;
    }
    
    
    /*========================================================================*/
    /*========================== Encapsulation ===============================*/
    /*========================================================================*/

    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }
    
            @Override
    public String toString() {
        return "Cargaison{" + "reference=" + reference + ", distance=" + distance + ", date_livraison=" + date_livraison + '}';
    }
}
