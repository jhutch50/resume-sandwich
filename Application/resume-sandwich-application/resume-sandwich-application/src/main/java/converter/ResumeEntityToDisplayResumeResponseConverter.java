package converter;

import com.jhutch50.resumesandwichapplication.model.Links;
import com.jhutch50.resumesandwichapplication.model.Self;
import com.jhutch50.resumesandwichapplication.model.response.DisplayResumeResponse;
import com.jhutch50.resumesandwichapplication.rest.ResourceConstants;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;
public class ResumeEntityToDisplayResumeResponseConverter implements Converter<ResumeEntity, DisplayResumeResponse>{

	@Override
	public DisplayResumeResponse convert(ResumeEntity source) {
		// TODO Auto-generated method stub
		
		DisplayResumeResponse displayResumeResponse = new DisplayResumeResponse();
		if(null != source.getId())
			displayResumeResponse.setId(source.getId());
			displayResumeResponse.setResumeNumber(source.getResumeNumber());
			displayResumeResponse.setActivityEntityList(source.getActivityEntityList());
			displayResumeResponse.setEducationEntityList(source.getEducationEntityList());
			displayResumeResponse.setProjectsEntityList(source.getProjectsEntityList());
			displayResumeResponse.setUserInfoEntityList(source.getUserInfoEntityList());
			displayResumeResponse.setVolunteerExperienceEntityList(source.getVolunteerExperienceEntityList());
			displayResumeResponse.setSkillsEntityList(source.getSkillsEntityList());
			displayResumeResponse.setWorkExperienceEntityList(source.getWorkExperienceEntityList());
			displayResumeResponse.setEthicEntityList(source.getEthicEntityList());
			
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.RESUME_DISPLAY + "/" + source.getId());
		links.setSelf(self);
		
		displayResumeResponse.setLinks(links);
		
		return displayResumeResponse;
	}

	
	
}