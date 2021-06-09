package sopra.ShareYourFood.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IProduitRepository;


@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitRestController {

	@Autowired
	private IProduitRepository produitRepo;

	@GetMapping("")
	@JsonView(Views.ViewProduit.class)
	public List<Produit> findAll() {
		return produitRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Produit find(@PathVariable String id) {

		Optional<Produit> optProduit = produitRepo.findById(id);

		if (optProduit.isPresent()) {
			return optProduit.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	public Produit create(@RequestBody Produit produit) {
		produit = produitRepo.save(produit);

		return produit;
	}

	@PutMapping("/{id}")
	public Produit update(@RequestBody Produit produit, @PathVariable String id) {
		if (!produitRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		produit = produitRepo.save(produit);
		return produit;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		produitRepo.deleteById(id);
	}
}
