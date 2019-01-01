package org.jlobato.gpro.dao.mybatis.facade;

import java.util.List;

import org.jlobato.gpro.dao.mybatis.mappers.CategoryMapper;
import org.jlobato.gpro.dao.mybatis.model.Category;
import org.jlobato.gpro.dao.mybatis.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FachadaCategory {
	
	@Autowired
	private CategoryMapper categoryDAO;
	
	/**
	 * 
	 * @return
	 */
	public List<Category> getCategories() {
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("lvl_category");
		return categoryDAO.selectByExample(example);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Category getCategoryByCode(String code) {
		Category result = null;
		CategoryExample example = new CategoryExample();
		example.createCriteria().andCodeAltCategoryEqualTo(code);
		List<Category> category = categoryDAO.selectByExample(example);
		if (!category.isEmpty()) {
			result = category.get(0);
		}
		
		return result;
	}

}
