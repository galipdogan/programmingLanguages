package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	public void add(ProgrammingLanguage programmingLanguage);
	public void update(ProgrammingLanguage programmingLanguage);
	public void delete(int id);
	ProgrammingLanguage getById(int id); 
	boolean checkIfNameExist (ProgrammingLanguage programmingLanguage);
	List<ProgrammingLanguage> getAll();
}
