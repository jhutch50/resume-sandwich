package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.model.request.EthicRequest;
import com.jhutch50.resumesandwichapplication.entity.EthicEntity;

public class EthicRequestToEthicEntityConverter implements Converter<EthicRequest, EthicEntity>{

	@Override
	public EthicEntity convert(EthicRequest source) {
		EthicEntity ethicEntity = new EthicEntity();
		
		ethicEntity.setEthicStatement(source.getEthicStatement());
		
		if (null != source.getId())
			ethicEntity.setId(source.getId());
		return ethicEntity;
	}

}
