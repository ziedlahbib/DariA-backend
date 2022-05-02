package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Annonce;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AnnonceRepository;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserService;
import java.util.List;
import java.util.Objects;

@Service
public class AnnonceServiceImpl implements AnnonceService  {
	
	@Autowired
    private AnnonceRepository annonceRepository;
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	FileDBRepository filedbrepo;
  
    // save operation
    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }
  
    // read operation
    @Override
    public List<Annonce> fetchAnnonceList() {
        return (List<Annonce>) annonceRepository.findAll();
    }
  
    // update operation
    @Override
    public Annonce updateAnnonce(Annonce annonce, Long annonceId) {
    	Annonce annonceDB = annonceRepository.findById(annonceId).get();
  
        if (Objects.nonNull(annonce.getTitre()) && !"".equalsIgnoreCase(annonce.getTitre())) {
            annonceDB.setTitre(annonce.getTitre());
        }
  
        if (Objects.nonNull(annonce.getPrix()) && !"".equals(annonce.getPrix())) {
            annonceDB.setPrix(annonce.getPrix());
        }
  
        if (Objects.nonNull(annonce.getDescription()) && !"".equalsIgnoreCase(annonce.getDescription())) {
            annonceDB.setTitre(annonce.getDescription());
        }
  
        
  
        return annonceRepository.save(annonceDB);
    }
  
    // delete operation
    @Override
    public void deleteAnnonceById(Long annonceId) {
        annonceRepository.deleteById(annonceId);
    }

	@Override
	public Annonce retrieveAnnonce(Long id) {
		
		return annonceRepository.findById(id).get();
	}

	@Override
	public Annonce retrieveAnnonce(String titre) {
		
		return annonceRepository.findByTitre(titre);
	} 
	@Override
	public void affecterFileToAnnonce(Long idFiles, Long idTrip) {
		Annonce t=annonceRepository.findById(idTrip).orElse(null);
		
			FileDB f=filedbrepo.findById(idFiles).orElse(null);
			t.setFiles(f);
			annonceRepository.save(t);
		
		
	}


  
}
	
	