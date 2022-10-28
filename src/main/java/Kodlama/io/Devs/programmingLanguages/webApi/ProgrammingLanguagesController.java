package Kodlama.io.Devs.programmingLanguages.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguagesController {
	public ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("/add")
	public void add (ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}
	
	@PutMapping("/update")
	public void update (ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete (int id) throws Exception {
		programmingLanguageService.delete(id);
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() throws Exception{
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public ProgrammingLanguage getbyid(int id) throws Exception{
		return programmingLanguageService.getById(id);
	}
	
}
