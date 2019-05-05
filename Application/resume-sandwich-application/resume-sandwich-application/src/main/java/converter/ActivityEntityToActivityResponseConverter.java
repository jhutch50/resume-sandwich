package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;
import com.jhutch50.resumesandwichapplication.model.response.ActivityResponse;

public class ActivityEntityToActivityResponseConverter implements Converter<ActivityEntity, ActivityResponse>{

	@Override
	public ActivityResponse convert(ActivityEntity source) {
		ActivityResponse activityResponse = new ActivityResponse();
		
		activityResponse.setClubName(source.getClubName());
		activityResponse.setEndDate(source.getEndDate());
		activityResponse.setStartDate(source.getStartDate());
		activityResponse.setSkillsA(source.getSkillsA());
		activityResponse.setSkillsB(source.getSkillsB());
		activityResponse.setSkillsC(source.getSkillsC());
		activityResponse.setTitle(source.getTitle());
		
		if(null != source.getResumeEntity())
			activityResponse.setId(source.getResumeEntity().getId());
		return activityResponse;
	}

}
