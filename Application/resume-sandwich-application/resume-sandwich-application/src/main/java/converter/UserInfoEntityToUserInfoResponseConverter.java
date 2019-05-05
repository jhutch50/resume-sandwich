package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.UserInfoEntity;
import com.jhutch50.resumesandwichapplication.model.response.UserInfoResponse;

public class UserInfoEntityToUserInfoResponseConverter implements Converter<UserInfoEntity, UserInfoResponse>{

	@Override
	public UserInfoResponse convert(UserInfoEntity source) {
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		
		userInfoResponse.setFirstname(source.getFirstname());
		userInfoResponse.setLastname(source.getLastname());
		userInfoResponse.setEmail(source.getEmail());
		userInfoResponse.setPhone(source.getPhone());
		userInfoResponse.setLinkedIn(source.getLinkedIn());
		userInfoResponse.setGitHub(source.getGitHub());
		
		if(null != source.getResumeEntity())
			userInfoResponse.setId(source.getResumeEntity().getId());
		return userInfoResponse;
	}

}