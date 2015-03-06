package com.jfi.myEnterpriseApp.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jfi.myEnterpriseApp.HomeController;
import com.jfi.myEnterpriseApp.domain.MenuItem;
import com.jfi.myEnterpriseApp.domain.MenuItems;

@Service(value="IMenu")
public class MenuService implements IMenu {

	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);
	
	@Override
	public MenuItems GetAppMenus() {
		//Mock Data
		MenuItems menuItems = new MenuItems();
		MenuItem parent1 = new MenuItem(1,"Sales Order" , "#",1,false);
		parent1.addChild(new MenuItem(2,"Sales Order Maintenance" , "/page/so/create",1,true));
		parent1.addChild(new MenuItem(3,"Sales Order Browse" , "/page/so/browse",2,true));
		menuItems.add(parent1);
		
		MenuItem parent2 = new MenuItem(4,"Shipment" , "#",2,false);
		parent2.addChild(new MenuItem(5,"SO Shipment" , "/page/shipment/create",1,true));
		parent2.addChild(new MenuItem(6,"Shipping Browse" , "/page/shipping/browse",2,true));
		menuItems.add(parent2);
		
		logger.info("Running into GetAppMenus");
		return menuItems;
	}

}
