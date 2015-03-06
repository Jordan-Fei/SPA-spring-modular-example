package com.jfi.myEnterpriseApp.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	private final int id;
	private final String name;
	private final String path;
	private final int weight;
	private final boolean isLeaf;
	

	private final List<MenuItem> children;
	
	public MenuItem(int id, String name, String path, int weight, boolean isLeaf) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.weight = weight;
		this.isLeaf = isLeaf;
		
		if(!this.isLeaf){
			this.children = new ArrayList<MenuItem>();
		}
		else
		{
			this.children = null;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public void addChild(MenuItem child){
		if(!this.isLeaf){
			if(!this.children.contains(child)){
				this.children.add(child);
			}
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public int getWeight() {
		return weight;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public List<MenuItem> getChildren() {
		return children;
	}
}
