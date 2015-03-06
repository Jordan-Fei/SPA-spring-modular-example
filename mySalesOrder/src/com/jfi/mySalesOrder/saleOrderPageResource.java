package com.jfi.mySalesOrder;

import java.util.ArrayList;
import java.util.List;

import com.jfi.myCommon.page.IPageResource;

/*
 * Instead of using this approach to load resources, load resource lazy using angularjs approach on front end was employed.
 */
public class saleOrderPageResource implements IPageResource {

	@Override
	public List<String> registerJavaScripts() {
		ArrayList<String> jsList = new ArrayList<String>();
		jsList.add("/resources/js/socreateController.js");
		jsList.add("/resources/js/sofindController.js");
		jsList.add("/resources/js/soService.js");
		
		return jsList;
	}

	@Override
	public List<String> registerCSS() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

}
