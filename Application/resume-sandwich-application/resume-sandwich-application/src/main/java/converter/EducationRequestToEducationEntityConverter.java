package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.EducationEntity;
import com.jhutch50.resumesandwichapplication.model.request.EducationRequest;

public class EducationRequestToEducationEntityConverter implements Converter<EducationRequest, EducationEntity> {

	@Override
	public EducationEntity convert(EducationRequest source) {
		EducationEntity educationEntity = new EducationEntity();

		educationEntity.setUniversityName(source.getUniversityName());
		educationEntity.setEndDate(source.getEndDate());
		educationEntity.setStartDate(source.getStartDate());
		educationEntity.setConcentration(source.getConcentration());
		educationEntity.setHonors(source.getHonors());
		educationEntity.setMajor(source.getMajor());
		educationEntity.setCity(source.getCity());
		educationEntity.setDegree(source.getDegree());
		educationEntity.setGpa(source.getGpa());
		educationEntity.setState(source.getState());
		
		if (null != source.getId())
			educationEntity.setId(source.getId());

		return educationEntity;
	}
}