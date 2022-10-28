package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() throws Exception {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguageRepository.checkIfNameExist(programmingLanguage) || programmingLanguage.getName() == null
				|| programmingLanguage.getName().length() == 0) {
			programmingLanguageRepository.add(programmingLanguage);
		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		/*
		 * if (!programmingLanguageRepository.checkIfNameExist(programmingLanguage) ||
		 * programmingLanguage.getName() == null ||
		 * programmingLanguage.getName().length() == 0) {
		 * this.programmingLanguageRepository.update(programmingLanguage); }
		 */
		
		programmingLanguageRepository.update(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {
		if (programmingLanguageRepository.getById(id) != null) {
			programmingLanguageRepository.delete(id);
		}

	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public boolean checkIfNameExist(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguageRepository.checkIfNameExist(programmingLanguage)) {
			return true;
		}
		return false;
	}

}
