package org.jlobato.gpro.dao.mybatis.facade;

import java.util.Optional;

import org.jlobato.gpro.dao.mybatis.mappers.TyreBrandMapper;
import org.jlobato.gpro.dao.mybatis.model.TyreBrand;
import org.jlobato.gpro.dao.mybatis.model.TyreBrandExample;
import org.jlobato.gpro.dao.mybatis.model.TyreBrandWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FachadaTyres {
	
	@Autowired
	private TyreBrandMapper tyreBrandDAO;
	
	/**
	 * 
	 * @param tyreBrandName
	 * @param tyreBrandCode
	 * @return
	 */
	public TyreBrand addTyreBrand(String tyreBrandName, String tyreBrandCode) {
		return addTyreBrand(tyreBrandName, tyreBrandCode, null, null);
	}

	/**
	 * 
	 * @param tyreBrandName
	 * @param tyreBrandCode
	 * @param tyreBrandImage
	 * @param tyreBrandIcon
	 * @return
	 */
	public TyreBrand addTyreBrand(String tyreBrandName, String tyreBrandCode, byte[] tyreBrandImage, byte[] tyreBrandIcon) {
		TyreBrandWithBLOBs result = new TyreBrandWithBLOBs().withTyreBrandImage(tyreBrandImage).withTyreBrandIcon(tyreBrandIcon);
		result.withTyreBrandName(tyreBrandName).withTyreBrandCode(tyreBrandCode);
		tyreBrandDAO.insert(result);
		tyreBrandDAO.updateByPrimaryKey(result.withTyreBrandName(tyreBrandName).withTyreBrandCode(tyreBrandCode));
		return result;
	}
	
	/**
	 * 
	 * @param tyreBrandName
	 * @param tyreBrandCode
	 * @param tyreBrandImage
	 * @param tyreBrandIcon
	 * @return
	 */
	public TyreBrand updateTyreBrand(String tyreBrandName, String tyreBrandCode, byte[] tyreBrandImage, byte[] tyreBrandIcon) {
		return updateTyreBrand(new TyreBrandWithBLOBs()
				.withTyreBrandIcon(tyreBrandIcon)
				.withTyreBrandImage(tyreBrandImage)
				.withTyreBrandName(tyreBrandName)
				.withTyreBrandCode(tyreBrandCode)
			);
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public TyreBrand updateTyreBrand(TyreBrand record) {
		tyreBrandDAO.updateByPrimaryKey(record);
		return record;
	}
	
	/**
	 * 
	 * @param tyreBrandCode
	 * @return
	 */
	public TyreBrand getTyreBrand(String tyreBrandCode) {
		TyreBrand result = null;
		Optional<String> criteria = Optional.ofNullable(tyreBrandCode);
		if (criteria.isPresent()) {
			TyreBrandExample example = new TyreBrandExample();
			example.createCriteria().andTyreBrandCodeEqualTo(tyreBrandCode);
			
			result = tyreBrandDAO.selectByExample(example).stream().findFirst().orElse(null);
		}
		return result;
	}
	
	/**
	 * 
	 * @param idTyreBrand
	 * @return
	 */
	public TyreBrand getTyreBrand(Short idTyreBrand) {
		return tyreBrandDAO.selectByPrimaryKey(idTyreBrand);
	}
	
	/**
	 * 
	 * @param idTyreBrand
	 * @return
	 */
	public byte[] getTyreBrandImage(Short idTyreBrand) {
		return tyreBrandDAO.selectByPrimaryKey(idTyreBrand).getTyreBrandImage();
	}
	
	/**
	 * 
	 * @param idTyreBrand
	 * @return
	 */
	public byte[] getTyreBrandIcon(Short idTyreBrand) {
		return tyreBrandDAO.selectByPrimaryKey(idTyreBrand).getTyreBrandIcon();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		ClassPathXmlApplicationContext contexto = null;
		contexto = new ClassPathXmlApplicationContext("/spring-applicationContext.xml");
		
		FachadaTyres fachadaRepos = contexto.getBean(FachadaTyres.class);
		
		fachadaRepos.addTyreBrand("Dunnolop", "DU");
		
		contexto.close();
	}

}
