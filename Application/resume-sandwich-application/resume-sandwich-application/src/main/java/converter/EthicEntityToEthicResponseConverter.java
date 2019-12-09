package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.EthicEntity;
import com.jhutch50.resumesandwichapplication.model.response.EthicResponse;

public class EthicEntityToEthicResponseConverter implements Converter<EthicEntity, EthicResponse>{

	@Override
	public EthicResponse convert(EthicEntity source) {
		EthicResponse ethicResponse = new EthicResponse();
		
		ethicResponse.setEthicStatement(source.getEthicStatement());
		
		if(null != source.getResumeEntity())
			ethicResponse.setId(source.getResumeEntity().getId());
		return ethicResponse;
	}

}
