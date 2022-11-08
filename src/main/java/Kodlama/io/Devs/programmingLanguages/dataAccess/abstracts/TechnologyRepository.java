package Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.programmingLanguages.entities.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
