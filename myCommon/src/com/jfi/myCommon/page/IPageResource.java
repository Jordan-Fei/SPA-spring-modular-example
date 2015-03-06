package com.jfi.myCommon.page;

import java.util.List;

/**
 * @author Jordan
 * Register what page resource(javascript/css) in this interface.
 * Relative resource path should be registered.
 * 
 * An example for resource path: "/resources/js/menuService.js"
 *
 * Note: If the page does not need resources, return empty list.
 */
public interface IPageResource {

	List<String> registerJavaScripts();
	
	List<String> registerCSS();
}
