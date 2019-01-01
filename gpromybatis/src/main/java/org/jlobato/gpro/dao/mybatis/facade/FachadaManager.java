package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.ManagerHistoryMapper;
import org.jlobato.gpro.dao.mybatis.mappers.ManagerMapper;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.jlobato.gpro.dao.mybatis.model.ManagerExample;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistory;
import org.jlobato.gpro.dao.mybatis.model.ManagerHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author JLOBATO
 *
 */
@Service
@Transactional
public class FachadaManager {
	
    @Autowired
    protected ManagerMapper managerDAO;
    
    @Autowired
    protected ManagerHistoryMapper managerHistoryDAO;
	
	/**
	 * 
	 * @return
	 */
	public List<Manager> getManagersList() {
		ManagerExample managerExample = new ManagerExample();
		managerExample.setOrderByClause("first_name, last_name");
		
		return managerDAO.selectByExample(managerExample);
	}
	
	/**
	 * 
	 * @param idManager
	 * @return
	 */
	public Manager getManager(Short idManager) {
		Manager result = null;
		if (idManager != null) {
			result = managerDAO.selectByPrimaryKey(idManager);
		}
		return result;
	}
	
	/**
	 * 
	 * @param codManager
	 * @return
	 */
	public Manager getManagerByCode(String codManager) {
		Manager result = null;
		ManagerExample managerExample = new ManagerExample();
		managerExample.createCriteria().andCodeManagerEqualTo(codManager);
		
		List<Manager> managers = managerDAO.selectByExample(managerExample);
		if (!managers.isEmpty()) {
			result = managers.get(0);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public Manager addManager(Manager record) {
		managerDAO.insert(record);
		return record;
	}
	
	/**
	 * 
	 * @param codeManager
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Manager addManager(String codeManager, String firstName, String lastName) {
		Manager result = new Manager().withCodeManager(codeManager).withFirstName(firstName).withLastName(lastName);
		return addManager(result);
	}
	
	/**
	 * 
	 * @param codeManager
	 * @param avatar
	 * @return
	 */
	public Manager setManagerAvatar(String codeManager, byte[] avatar) {
		Manager manager = getManagerByCode(codeManager);
		manager.setAvatarImg(avatar);
		managerDAO.updateByPrimaryKeyWithBLOBs(manager);
		return manager;
	}

	/**
	 * 
	 * @param codeManager
	 * @param idCategory
	 * @param idGroup
	 * @param idSeason
	 * @param idTyreBrand
	 */
	public void addManagerHistory(String codeManager, Short idCategory, Short idGroup, Short idSeason, Short idTyreBrand) {
		ManagerHistory record = new ManagerHistory()
				.withIdCategory(idCategory)
				.withIdGroup(idGroup)
				.withIdSeason(idSeason)
				.withIdTyreBrand(idTyreBrand);
		addManagerHistory(getManagerByCode(codeManager), record);
	}

	/**
	 * 
	 * @param manager
	 * @param record
	 */
	public void addManagerHistory(Manager manager, ManagerHistory record) {
		addManagerHistory(record.withIdManager(manager.getIdManager()));
	}
	
	/**
	 * 
	 * @param record
	 */
	public void addManagerHistory(ManagerHistory record) {
		managerHistoryDAO.insert(record);
	}
	
	/**
	 * 
	 * @param codeManager
	 * @param idSeason
	 * @param idCategory
	 * @param idGroup
	 * @param idTyreBrand
	 */
	public void updateManagerHistory(String codeManager, Short idSeason, Short idCategory, Short idGroup, Short idTyreBrand) {
		ManagerHistoryExample example = new ManagerHistoryExample();
		example.createCriteria()
				.andIdManagerEqualTo(getManagerByCode(codeManager).getIdManager())
				.andIdSeasonEqualTo(idSeason);
		List<ManagerHistory> records = managerHistoryDAO.selectByExample(example);
		records.forEach(record -> {
			record.withIdCategory(idCategory).withIdGroup(idGroup).withIdTyreBrand(idTyreBrand);
			managerHistoryDAO.updateByPrimaryKey(record);
		});
		
	}
	
	/**
	 * 
	 * @param record
	 */
	public void updateManagerHistory(ManagerHistory record) {
		managerHistoryDAO.updateByPrimaryKey(record);
	}
	
}
