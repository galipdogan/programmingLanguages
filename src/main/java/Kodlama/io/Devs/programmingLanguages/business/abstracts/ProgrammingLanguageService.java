package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	public void add(ProgrammingLanguage programmingLanguage)throws Exception;
	public void update(ProgrammingLanguage programmingLanguage)throws Exception;
	public void delete(int id)throws Exception;
	ProgrammingLanguage getById(int id)throws Exception; 
	boolean checkIfNameExist (ProgrammingLanguage programmingLanguage)throws Exception;
	List<ProgrammingLanguage> getAll() throws Exception;
}
