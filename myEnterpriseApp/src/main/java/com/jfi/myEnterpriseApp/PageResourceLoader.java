package com.jfi.myEnterpriseApp;

import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.jfi.myCommon.page.IPageResource;

/**
 * 
 * @author Jordan
 * Use reflection to create the page resource register instances to get the page resources.
 * 
 * Need to improve: Load page source by module or by request url path.
 *
 */
public final class PageResourceLoader {

	private static volatile PageResourceLoader instance = null;
	private List<String> javaScriptsList;
	private List<String> cssList;
	
	public List<String> getJavaScriptsList() {
		return javaScriptsList;
	}

	public List<String> getCssList() {
		return cssList;
	}

	private PageResourceLoader(){
		this.javaScriptsList = null;
		this.cssList = null;
		
		Reflections reflections = new Reflections("com.jfi");
		Set<Class<? extends IPageResource>> subTypes = reflections.getSubTypesOf(IPageResource.class);
        for(Class clazz : subTypes){
        	try {
        		IPageResource pageResource = (IPageResource)clazz.newInstance();
        		this.javaScriptsList = pageResource.registerJavaScripts();
        		this.cssList = pageResource.registerCSS();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}
	
	public static PageResourceLoader getInstance() {
		if(null == instance){
			synchronized(PageResourceLoader.class){
				instance = new PageResourceLoader();
			}
		}
		
		return instance;
	}
}
