package Kodlama.io.Devs.programmingLanguages.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "technologies" })
@Table(name = "programmingLanguages")
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // idyi otomatik arttir
	@Column(name = "programmingLanguage_id")
	public int programmingLanguageId;

	@Column(name = "programmingLanguage_name")
	public String programmingLanguageName;

	@OneToMany(mappedBy = "programmingLanguage")
	private List<Technology> technologies;

}
