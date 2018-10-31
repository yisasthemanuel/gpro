package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.ManagerMapper;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.jlobato.gpro.dao.mybatis.model.ManagerExample;
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

}
