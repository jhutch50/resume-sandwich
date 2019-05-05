package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.model.request.ActivityRequest;
import com.jhutch50.resumesandwichapplication.entity.ActivityEntity;

public class ActivityRequestToActivityEntityConverter implements Converter<ActivityRequest, ActivityEntity>{

	@Override
	public ActivityEntity convert(ActivityRequest source) {
		ActivityEntity activityEntity = new ActivityEntity();
		
		activityEntity.setClubName(source.getClubName());
		activityEntity.setEndDate(source.getEndDate());
		activityEntity.setStartDate(source.getStartDate());
		activityEntity.setSkillsA(source.getSkillsA());
		activityEntity.setSkillsB(source.getSkillsB());
		activityEntity.setSkillsC(source.getSkillsC());
		activityEntity.setTitle(source.getTitle());
		
		if (null != source.getId())
			activityEntity.setId(source.getId());
		return activityEntity;
	}

}
