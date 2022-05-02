package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.services.AnnonceService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/annonces")
public class AnnonceController {

	// Annotation
	//autoweired taamel el recherche bein selon type 
	@Autowired 
	AnnonceService annonceService;

	// Save operation
	@PostMapping("/add-annonces")
	public Annonce saveAnnonce(@RequestBody Annonce annonce) {

		return annonceService.saveAnnonce(annonce);
	}

	// Read operation
	@GetMapping("/retreive-annonces")
	public List<Annonce> fetchAnnonceList() {

		return annonceService.fetchAnnonceList();
	}

	// Update operation
	@PutMapping("/update-annonces/{id}")
	public Annonce updateDepartment(@RequestBody Annonce annonce, @PathVariable("id") Long annonceId) {

		return annonceService.updateAnnonce(annonce, annonceId);
	}

	// Delete operation
	@DeleteMapping("/delete-annonces/{id}")
	public String deleteAnnonceById(@PathVariable("id") Long annonceId) {

		annonceService.deleteAnnonceById(annonceId);
		return "Deleted Successfully";
	}
	// Filtrage operation
	
	@GetMapping("/annonceById/{id}")
    public Annonce findAnnonceById(@PathVariable long id) {
        return annonceService.retrieveAnnonce(id);
    }
	
	@GetMapping("/annonceByTitre/{titre}")
    public Annonce findAnnonceByTitre(@PathVariable String titre) {
        return annonceService.retrieveAnnonce(titre);
    }
	@PutMapping("/affecter-fileToAnnonce/{id-annonce}/{files}")
	@ResponseBody
	public void affecterFilesToTrip(@PathVariable("files") Long idfile, @PathVariable("id-annonce") Long idAnnonce) {
		annonceService.affecterFileToAnnonce(idfile, idAnnonce);

	}
}
