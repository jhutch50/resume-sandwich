package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.UserInfoEntity;
import com.jhutch50.resumesandwichapplication.model.request.UserInfoRequest;

public class UserInfoRequestToUserInfoEntityConverter implements Converter<UserInfoRequest, UserInfoEntity>{

	@Override
	public UserInfoEntity convert(UserInfoRequest source) {
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		
		userInfoEntity.setFirstname(source.getFirstname());
		userInfoEntity.setLastname(source.getLastname());
		userInfoEntity.setEmail(source.getEmail());
		userInfoEntity.setPhone(source.getPhone());
		userInfoEntity.setLinkedIn(source.getLinkedIn());
		userInfoEntity.setGitHub(source.getGitHub());
		
		if (null != source.getId())
			userInfoEntity.setId(source.getId());

		return userInfoEntity;
	}

}