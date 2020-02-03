package org.jlobato.gpro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jlobato.gpro.dao.mybatis.facade.FachadaManager;
import org.jlobato.gpro.dao.mybatis.facade.FachadaSeason;
import org.jlobato.gpro.dao.mybatis.facade.FachadaTeam;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author JLOBATO
 *
 */
@Controller
@RequestMapping("/results")
public class ResultsController {
	
	/**
	 * 
	 */
	@Autowired
	private FachadaTeam fachadaTeam;
	
	/**
	 * 
	 */
	@Autowired
	private FachadaSeason fachadaSeason;
	
	/**
	 * 
	 */
	@Autowired
	private FachadaManager fachadaManager;
	
	
	/**
	 * 
	 */
	private static final transient Logger logger = LoggerFactory.getLogger(ResultsController.class);
	

	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/pre-results", method = RequestMethod.GET)
	public ModelAndView results(HttpServletRequest request, HttpSession session)	{
		logger.debug("ResultsController.results - begin");
		
		ModelAndView modelAndView = new ModelAndView();
		//Modelo
		//TODO Ahora mismo añadimos el equipo por defecto (GPR) pero esto será sensible al usuario
		modelAndView.addObject("team", fachadaTeam.getDefaultTeam());
		
		//TODO Ahora añadimos todos los managers. Hay que añadir sólo los del equipo seleccionado
		modelAndView.addObject("managersList", fachadaManager.getManagersList());
		//TODO Falta materializar los circuitos de cada carrera
        modelAndView.addObject("racesList", fachadaSeason.getRaces(fachadaSeason.getCurrentSeason()));
        
        //TODO Falta obtener la temporada actual al cambiar el combo
        modelAndView.addObject("seasonsList", fachadaSeason.getAvailableSeasons());
        modelAndView.addObject("currentSeason", fachadaSeason.getCurrentSeason());
        
		//Vista
		modelAndView.setViewName("/results/results");
		
		logger.debug("ResultsController.results - end");
		return modelAndView;
	}
	
	@RequestMapping(value = "/allraces", method = RequestMethod.GET, produces = "application/json")
	//public @ResponseBody List<Race> allraces(HttpServletRequest request, HttpSession session, String codSeason)	{
	public @ResponseBody String allraces(HttpServletRequest request, HttpSession session, String codSeason)	{
		logger.debug("ResultsController.getSeasonRaces - begin for season " + request.getParameter("codSeason"));
		logger.debug("ResultsController.getSeasonRaces - begin for season " + codSeason);
		
		
		logger.debug("ResultsController.getSeasonRaces - end for season " + request.getParameter("codSeason"));
		//return new ArrayList<Race>();
		return "{codigo: apatrullando}";
	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public ModelAndView getResults(@RequestParam(value="currentSeason", required=false) String currentSeason)	{
		//Modelo
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Texto", "Eso es asín");
		
        Season current = null;
        if (currentSeason != null) {
        	current = fachadaSeason.getSeason(new Integer(currentSeason));
        } else {
            current = fachadaSeason.getCurrentSeason();
        }
        
        modelAndView.addObject("currentSeasonID", current.getIdSeason());        
        
		
		//Vista
		modelAndView.setViewName("/results/putresults");
		
		return modelAndView;
	}


}
