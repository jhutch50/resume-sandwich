package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.VolunteerExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.request.VolunteerExperienceRequest;

public class VolunteerExperienceRequestToVolunteerExperienceEntityConverter implements Converter<VolunteerExperienceRequest, VolunteerExperienceEntity>{

	@Override
	public VolunteerExperienceEntity convert(VolunteerExperienceRequest source) {
		VolunteerExperienceEntity volunteerExperienceEntity = new VolunteerExperienceEntity();
		
		volunteerExperienceEntity.setOrganization(source.getOrganization());
		volunteerExperienceEntity.setEndDate(source.getEndDate());
		volunteerExperienceEntity.setStartDate(source.getStartDate());
		volunteerExperienceEntity.setSkillsA(source.getSkillsA());
		volunteerExperienceEntity.setSkillsB(source.getSkillsB());
		volunteerExperienceEntity.setSkillsC(source.getSkillsC());
		volunteerExperienceEntity.setRole(source.getRole());
		volunteerExperienceEntity.setCity(source.getCity());
		volunteerExperienceEntity.setState(source.getState());
		if (null != source.getId())
			volunteerExperienceEntity.setId(source.getId());

		return volunteerExperienceEntity;
	}

}