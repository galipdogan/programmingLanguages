package Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTechnologyRequest {
	private int technologyId;
	private String technologyName;
}
