package org.jlobato.gpro.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jlobato.gpro.dao.mybatis.facade.FachadaGPRCup;
import org.jlobato.gpro.dao.mybatis.facade.FachadaManager;
import org.jlobato.gpro.dao.mybatis.facade.FachadaSeason;
import org.jlobato.gpro.dao.mybatis.model.CupStandingsSnapshot;
import org.jlobato.gpro.dao.mybatis.model.Manager;
import org.jlobato.gpro.dao.mybatis.model.Race;
import org.jlobato.gpro.dao.mybatis.model.Season;
import org.jlobato.gpro.dao.mybatis.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author jlobato
 *
 */
@Controller
public class GprcupController {
	
	
	/**
	 * 
	 */
	private static final transient Logger logger = LoggerFactory.getLogger(GprcupController.class);
	
	/**
	 * 
	 */
	@Autowired
	private FachadaSeason fachadaSeason;
	
	@Autowired
	/**
	 * 
	 */
	private FachadaManager fachadaManager;
	
	@Autowired
	private FachadaGPRCup fachadaCup;

	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/gprcup.html", method = RequestMethod.GET)
	public ModelAndView cup(HttpServletRequest request, HttpSession session)	{
		logger.debug("GprcupController.cup - begin");
		
        ModelAndView modelAndView = new ModelAndView();
        
        //Hago el sendredirect para que pille el tema gprcup
		String view = "redirect:/gprcup/main.html";
        modelAndView.setViewName(view);
        
		logger.debug("GprcupController.cup - end");
		return modelAndView;

	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/gprcup/main.html", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main(HttpServletRequest request,
			 @RequestParam(value="currentSeason", required=false) String currentSeason,
			HttpSession session)	{
		logger.debug("GprcupController.main - begin");
		
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("/gprcup/main");
        
        //Pedimos al delegado de negocio que nos pase la lista con los managers disponibles
        List<Manager> managers = fachadaManager.getManagersList();
        
        Season current = null;
        if (currentSeason != null) {
        	current = fachadaSeason.getSeason(new Integer(currentSeason));
        } else {
            current = fachadaSeason.getCurrentSeason();
        }
        
        Team team = fachadaCup.getDefaultTeam();
        
        CupStandingsSnapshot standings = fachadaCup.getStandings(current, team);
        
        if (standings != null) {
        	session.setAttribute("currentCupStandings", standings);
        	modelAndView.addObject("lastRace", standings.getIdRace());
        	modelAndView.addObject("lastSeason", standings.getIdSeason());
            logger.info("GprcupController.main - Clasificación correspondiente a la carrera: " + standings.getIdRace());
        }
        
        modelAndView.addObject("managersList", managers);
        modelAndView.addObject("racesList", fachadaSeason.getRaces(current));
        modelAndView.addObject("seasonList", fachadaSeason.getAvailableSeasons());
        
        logger.info("GprcupController.main - Temporada actual: " + current.getNameSeason());
        modelAndView.addObject("currentSeason", current);
        
//        List<Map<String, String>> tracks = fachadaSeason.getTracks(current);
//        logger.info("GprcupController.main - Circuitos actuales: " + tracks);
        
		logger.debug("GprcupController.main - end");
		return modelAndView;

	}
	
	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/gprcup/showStandings.html", method = RequestMethod.POST)
	public ModelAndView showStandings(HttpServletRequest request, HttpSession session) {
		logger.debug("GprcupController.showStandings - begin");
		
        ModelAndView modelAndView = new ModelAndView();
        
        //Creamos el objeto CupStandings
        CupStandingsSnapshot cupStandings = getCupStandings(request, session);
              
        //Colocamos en sesión la clasificación actual
        session.setAttribute("currentCupStandings", cupStandings);
        
        //Colocamos los objetos managers
        modelAndView.addObject("QF01", fachadaManager.getManager(cupStandings.getIdManagerQf1()));
        modelAndView.addObject("QF02", fachadaManager.getManager(cupStandings.getIdManagerQf2()));
        modelAndView.addObject("QF03", fachadaManager.getManager(cupStandings.getIdManagerQf3()));
        modelAndView.addObject("QF04", fachadaManager.getManager(cupStandings.getIdManagerQf4()));
        modelAndView.addObject("QF05", fachadaManager.getManager(cupStandings.getIdManagerQf5()));
        modelAndView.addObject("QF06", fachadaManager.getManager(cupStandings.getIdManagerQf6()));
        modelAndView.addObject("QF07", fachadaManager.getManager(cupStandings.getIdManagerQf7()));
        modelAndView.addObject("QF08", fachadaManager.getManager(cupStandings.getIdManagerQf8()));

        modelAndView.addObject("SF01", fachadaManager.getManager(cupStandings.getIdManagerSf1()));
        modelAndView.addObject("SF02", fachadaManager.getManager(cupStandings.getIdManagerSf2()));
        modelAndView.addObject("SF03", fachadaManager.getManager(cupStandings.getIdManagerSf3()));
        modelAndView.addObject("SF04", fachadaManager.getManager(cupStandings.getIdManagerSf4()));
        
        modelAndView.addObject("FI01", fachadaManager.getManager(cupStandings.getIdManagerFi1()));
        modelAndView.addObject("FI02", fachadaManager.getManager(cupStandings.getIdManagerFi2()));
        
        modelAndView.addObject("WI01", fachadaManager.getManager(cupStandings.getIdManagerWinner()));
        
        //Vista a preview
        modelAndView.setViewName("/gprcup/preview");
        
		logger.debug("GprcupController.showStandings - end");
		return modelAndView;

	}

	/**
	 * 
	 * @param request
	 * @param cupStandings
	 */
	private CupStandingsSnapshot getCupStandings(HttpServletRequest request, HttpSession session) {
		CupStandingsSnapshot result = new CupStandingsSnapshot();
		
		//Managers
        String manager01 = request.getParameter("qfManager01");
        logger.debug("GprcupController.getCupStandings.qfManager01 - " + manager01);
        
        String manager02 = request.getParameter("qfManager02");
        logger.debug("GprcupController.getCupStandings.qfManager02 - " + manager02);
        
        String manager03 = request.getParameter("qfManager03");
        logger.debug("GprcupController.getCupStandings.qfManager03 - " + manager03);
        
        String manager04 = request.getParameter("qfManager04");
        logger.debug("GprcupController.getCupStandings.qfManager04 - " + manager04);
        
        String manager05 = request.getParameter("qfManager05");
        logger.debug("GprcupController.getCupStandings.qfManager05 - " + manager05);
        
        String manager06 = request.getParameter("qfManager06");
        logger.debug("GprcupController.getCupStandings.qfManager06 - " + manager06);
        
        String manager07 = request.getParameter("qfManager07");
        logger.debug("GprcupController.getCupStandings.qfManager07 - " + manager07);
        
        String manager08 = request.getParameter("qfManager08");
        logger.debug("GprcupController.getCupStandings.qfManager08 - " + manager08);
        
        String sfmanager01 = request.getParameter("sfManager01");
        logger.debug("GprcupController.getCupStandings.sfManager01 - " + sfmanager01);
        
        String sfmanager02 = request.getParameter("sfManager02");
        logger.debug("GprcupController.getCupStandings.sfManager02 - " + sfmanager02);
        
        String sfmanager03 = request.getParameter("sfManager03");
        logger.debug("GprcupController.getCupStandings.sfManager03 - " + sfmanager03);
        
        String sfmanager04 = request.getParameter("sfManager04");
        logger.debug("GprcupController.getCupStandings.sfManager04 - " + sfmanager04);
        
        String fmanager01 = request.getParameter("fManager01");
        logger.debug("GprcupController.getCupStandings.fManager01 - " + fmanager01);
        
        String fmanager02 = request.getParameter("fManager02");
        logger.debug("GprcupController.getCupStandings.fManager02 - " + fmanager02);
        
        String fmanagerWinner = request.getParameter("fManagerWinner");
        logger.debug("GprcupController.getCupStandings.fManagerWinner - " + fmanagerWinner);
        

        //Scores
        String qfmanager01Score = request.getParameter("qfManager01Score");
        logger.debug("GprcupController.getCupStandings.qfManager01Score - " + qfmanager01Score);
        
        String qfmanager02Score = request.getParameter("qfManager02Score");
        logger.debug("GprcupController.getCupStandings.qfManager02Score - " + qfmanager02Score);
        
        String qfmanager03Score = request.getParameter("qfManager03Score");
        logger.debug("GprcupController.getCupStandings.qfManager03Score - " + qfmanager03Score);
        
        String qfmanager04Score = request.getParameter("qfManager04Score");
        logger.debug("GprcupController.getCupStandings.qfManager04Score - " + qfmanager04Score);
        
        String qfmanager05Score = request.getParameter("qfManager05Score");
        logger.debug("GprcupController.getCupStandings.qfManager05Score - " + qfmanager05Score);
        
        String qfmanager06Score = request.getParameter("qfManager06Score");
        logger.debug("GprcupController.getCupStandings.qfManager06Score - " + qfmanager06Score);
        
        String qfmanager07Score = request.getParameter("qfManager07Score");
        logger.debug("GprcupController.getCupStandings.qfManager07Score - " + qfmanager07Score);
        
        String qfmanager08Score = request.getParameter("qfManager08Score");
        logger.debug("GprcupController.getCupStandings.qfManager08Score - " + qfmanager08Score);
        
        String sfmanager01Score = request.getParameter("sfManager01Score");
        logger.debug("GprcupController.getCupStandings.sfManager01Score - " + sfmanager01Score);
        
        String sfmanager02Score = request.getParameter("sfManager02Score");
        logger.debug("GprcupController.getCupStandings.sfManager02Score - " + sfmanager02Score);
        
        String sfmanager03Score = request.getParameter("sfManager03Score");
        logger.debug("GprcupController.getCupStandings.sfManager03Score - " + sfmanager03Score);
        
        String sfmanager04Score = request.getParameter("sfManager04Score");
        logger.debug("GprcupController.getCupStandings.sfManager04Score - " + sfmanager04Score);
        
        String fmanager01Score = request.getParameter("fManager01Score");
        logger.debug("GprcupController.getCupStandings.fManager01Score - " + fmanager01Score);
        
        String fmanager02Score = request.getParameter("fManager02Score");
        logger.debug("GprcupController.getCupStandings.fManager02Score - " + fmanager02Score);
        
        result.setIdManagerQf1(getManagerID(manager01));
        result.setIdManagerQf2(getManagerID(manager02));
        result.setIdManagerQf3(getManagerID(manager03));
        result.setIdManagerQf4(getManagerID(manager04));
        result.setIdManagerQf5(getManagerID(manager05));
        result.setIdManagerQf6(getManagerID(manager06));
        result.setIdManagerQf7(getManagerID(manager07));
        result.setIdManagerQf8(getManagerID(manager08));
        
        /*Locale locale = RequestContextUtils.getLocale(request);
        
        NumberFormatter formater = new NumberFormatter();
        Number number = formater.parse(qfmanager01Score, locale);*/
        
        result.setScoreManagerQf1((qfmanager01Score != null && !"".equals(qfmanager01Score)) ? new BigDecimal(qfmanager01Score) : null);
        result.setScoreManagerQf2((qfmanager02Score != null && !"".equals(qfmanager02Score)) ? new BigDecimal(qfmanager02Score) : null);
        result.setScoreManagerQf3((qfmanager03Score != null && !"".equals(qfmanager03Score)) ? new BigDecimal(qfmanager03Score) : null);
        result.setScoreManagerQf4((qfmanager04Score != null && !"".equals(qfmanager04Score)) ? new BigDecimal(qfmanager04Score) : null);
        result.setScoreManagerQf5((qfmanager05Score != null && !"".equals(qfmanager05Score)) ? new BigDecimal(qfmanager05Score) : null);
        result.setScoreManagerQf6((qfmanager06Score != null && !"".equals(qfmanager06Score)) ? new BigDecimal(qfmanager06Score) : null);
        result.setScoreManagerQf7((qfmanager07Score != null && !"".equals(qfmanager07Score)) ? new BigDecimal(qfmanager07Score) : null);
        result.setScoreManagerQf8((qfmanager08Score != null && !"".equals(qfmanager08Score)) ? new BigDecimal(qfmanager08Score) : null);

        result.setIdManagerSf1(getManagerID(sfmanager01));
        result.setIdManagerSf2(getManagerID(sfmanager02));
        result.setIdManagerSf3(getManagerID(sfmanager03));
        result.setIdManagerSf4(getManagerID(sfmanager04));
        
        result.setScoreManagerSf1((sfmanager01Score != null && !"".equals(sfmanager01Score)) ? new BigDecimal(sfmanager01Score) : null);
        result.setScoreManagerSf2((sfmanager02Score != null && !"".equals(sfmanager02Score)) ? new BigDecimal(sfmanager02Score) : null);
        result.setScoreManagerSf3((sfmanager03Score != null && !"".equals(sfmanager03Score)) ? new BigDecimal(sfmanager03Score) : null);
        result.setScoreManagerSf4((sfmanager04Score != null && !"".equals(sfmanager04Score)) ? new BigDecimal(sfmanager04Score) : null);
        
        result.setIdManagerFi1(getManagerID(fmanager01));
        result.setIdManagerFi2(getManagerID(fmanager02));
        
        result.setScoreManagerFi1((fmanager01Score != null && !"".equals(fmanager01Score)) ? new BigDecimal(fmanager01Score) : null);
        result.setScoreManagerFi2((fmanager02Score != null && !"".equals(fmanager02Score)) ? new BigDecimal(fmanager02Score) : null);
        
        result.setIdManagerWinner(getManagerID(fmanagerWinner));
        
        //Recuperamos la carrera para la que se guarda la clasificación
        Race theRace = fachadaSeason.getRace(new Short(request.getParameter("currentRace")));
        if (theRace != null) {
            result.setIdRace(theRace.getIdRace());
        }
        
        //Identificamos la clave primaria de la clasificación (Season y Team)
        //Será mejor tomarlo de sesión
        //Season current = fachadaSeason.getCurrentSeason();
        //Season theSeason = fachadaSeason.getSeason(new Integer(request.getParameter("currentSeason")));
        //result.setIdSeason(theSeason.getIdSeason());
        result.setIdSeason(new Short(request.getParameter("currentSeason")));
        
        //Tomamos equipo por defecto. Esto en un futuro será el equipo asignado al usuario
        result.setIdTeam(fachadaCup.getDefaultTeam().getIdTeam());
        
        return result;
	}
	
	private Short getManagerID(String id) {
		Short result = null;
		try {
			result = new Short(id);
		} catch(Exception e) { }
		return result;
	}

	/**
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/gprcup/saveStandings.html", method = RequestMethod.POST)
	public ModelAndView saveStandings(HttpServletRequest request, HttpSession session) {
		logger.debug("GprcupController.saveStandings - begin");
		
        //Creamos el objeto CupStandings
        CupStandingsSnapshot cupStandings = getCupStandings(request, session);
        
        //Le decimos que lo guarde
        fachadaCup.saveStandings(cupStandings);
		
		//Redirigimos a la página principal. Esto se puede mejorar
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("currentSeason", cupStandings.getIdSeason());
        modelAndView.addObject("currentRace", cupStandings.getIdRace());
        String view = "redirect:/gprcup/main.html";
        modelAndView.setViewName(view);
        
		logger.debug("GprcupController.saveStandings - end");
		
		return modelAndView;
	}
}
