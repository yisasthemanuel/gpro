package org.jlobato.gpro.dao.mybatis.test;

import static org.junit.Assert.assertNotNull;

import org.jlobato.gpro.dao.mybatis.facade.FachadaCategory;
import org.jlobato.gpro.dao.mybatis.facade.FachadaManager;
import org.jlobato.gpro.dao.mybatis.facade.FachadaTyres;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.junit.Test;

public class ManagerHistoryTest extends MyBatisBaseTest {

	@Test
	public void test() {
		//Obtenemos el manager de test
		FachadaManager managerService = contexto.getBean(FachadaManager.class);
		FachadaCategory categoryService = contexto.getBean(FachadaCategory.class);
		FachadaTyres tyresService = contexto.getBean(FachadaTyres.class);
		assertNotNull(managerService);
		assertNotNull(categoryService);
		assertNotNull(tyresService);
		Manager manager = managerService.getManagerByCode("JESUS");
		managerService.addManagerHistory("JESUS",
				categoryService.getCategoryByCode("R").getIdCategory(),
				new Short((short)79),
				new Short((short)16),
				tyresService.getTyreBrand("PI").getIdTyreBrand());
		
		//TODO - Meter código de borrado
	}

}
