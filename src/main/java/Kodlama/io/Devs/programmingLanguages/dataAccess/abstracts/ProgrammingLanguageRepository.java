package Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts;

import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
	// void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	// public void update(ProgrammingLanguage programmingLanguage);
	// public void delete(int id);
	// ProgrammingLanguage getById(int id);
	//public boolean findByName(String name);
	// programmingLanguage);
	// List<ProgrammingLanguage> getAll();

}
