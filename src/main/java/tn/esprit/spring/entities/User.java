package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	
	

	public User(Long id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}



	// relation
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Annonce> Annonce;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Reclamation> Reclamation;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Contrat> Contrat;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Credit> Credit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<SouscriptionAssurance> SouscriptionAssurance;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Assurance> Assurance;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Abonnement> Abonnement;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	
	List<Avis> avis;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	List<Commentaire> commentaires;
}
