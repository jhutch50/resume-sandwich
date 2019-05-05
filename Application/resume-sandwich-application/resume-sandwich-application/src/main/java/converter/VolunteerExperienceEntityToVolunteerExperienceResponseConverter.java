package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.VolunteerExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.response.VolunteerExperienceResponse;

public class VolunteerExperienceEntityToVolunteerExperienceResponseConverter implements Converter<VolunteerExperienceEntity, VolunteerExperienceResponse>{

	@Override
	public VolunteerExperienceResponse convert(VolunteerExperienceEntity source) {
		VolunteerExperienceResponse volunteerExperienceResponse = new VolunteerExperienceResponse();
		
		volunteerExperienceResponse.setOrganization(source.getOrganization());
		volunteerExperienceResponse.setEndDate(source.getEndDate());
		volunteerExperienceResponse.setStartDate(source.getStartDate());
		volunteerExperienceResponse.setSkillsA(source.getSkillsA());
		volunteerExperienceResponse.setSkillsB(source.getSkillsB());
		volunteerExperienceResponse.setSkillsC(source.getSkillsC());
		volunteerExperienceResponse.setRole(source.getRole());
		volunteerExperienceResponse.setCity(source.getCity());
		volunteerExperienceResponse.setState(source.getState());
		
		if(null != source.getResumeEntity())
			volunteerExperienceResponse.setId(source.getResumeEntity().getId());
		return volunteerExperienceResponse;
	}

}