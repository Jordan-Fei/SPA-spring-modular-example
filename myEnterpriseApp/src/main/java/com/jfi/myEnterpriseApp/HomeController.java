package com.jfi.myEnterpriseApp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfi.myEnterpriseApp.Service.IMenu;
import com.jfi.myEnterpriseApp.domain.MenuItems;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IMenu appMenu;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * This api is for front angularJS route on HTML5 Mode.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/page/*/*", method = RequestMethod.GET)
	public String page(Locale locale, Model model) {
		logger.info("Request Page! The client locale is {}.", locale);
		
		return "home";
	}	
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET,produces={"application/json"})
	public @ResponseBody MenuItems GetMenu(){
		return appMenu.GetAppMenus();
	}
	
}
