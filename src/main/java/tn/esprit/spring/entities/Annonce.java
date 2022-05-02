package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Annonce implements Serializable {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private double prix;
	private Transaction transaction ;
	private TypeBien typedebien; 
	private Etat etat;
	private String localisation ;
	private double superficie ;
	private int nbrchambre ; 
	private int age ;
	private int etage;
	private int numero;
	private Date datecreation;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private FileDB files;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	@JsonManagedReference
	List<Avis> avis;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	@JsonManagedReference
	List<Commentaire> commaentaire;



	@Override
	public String toString() {
		return "Annonce [id=" + id + ", titre=" + titre + ", description=" + description 
				+ ", prix=" + prix + ", transaction=" + transaction + ", typedebien=" + typedebien + ", etat=" + etat
				+ ", localisation=" + localisation + ", superficie=" + superficie + ", nbrchambre=" + nbrchambre
				+ ", age=" + age + ", etage=" + etage + ", numero=" + numero + ", datecreation=" + datecreation
				+ ", avis=" + avis + ", commaentaire=" + commaentaire + ", user=" + user + ", Visite=" + Visite + "]";
	}



	
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TypeBien getTypedebien() {
		return typedebien;
	}

	public void setTypedebien(TypeBien typedebien) {
		this.typedebien = typedebien;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getNbrchambre() {
		return nbrchambre;
	}

	public void setNbrchambre(int nbrchambre) {
		this.nbrchambre = nbrchambre;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public Visite getVisite() {
		return Visite;
	}

	public void setVisite(Visite visite) {
		Visite = visite;
	}

	public Set<User> getUser() {
		return user;
	}


	public void setUser(Set<User> user) {
		this.user = user;
	}

	public List<Avis> getAvis() {
		return avis;
	}


	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}


	public List<Commentaire> getCommaentaire() {
		return commaentaire;
	}


	public void setCommaentaire(List<Commentaire> commaentaire) {
		this.commaentaire = commaentaire;
	}



	public FileDB getFiles() {
		return files;
	}




	public void setFiles(FileDB files) {
		this.files = files;
	}



	// relation
	@ManyToMany(cascade = CascadeType.ALL)

	private Set<User> user;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "Annonce")

	private Visite Visite;
}
