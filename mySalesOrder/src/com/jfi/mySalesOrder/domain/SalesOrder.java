package com.jfi.mySalesOrder.domain;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jfi.myCommon.serilization.JsonDateSerializer;

public class SalesOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1974341893731420718L;
	private String so_nbr;
	private String so_cust;
	private Date so_date;
	
	public String getSo_nbr() {
		return so_nbr;
	}
	
	public String getSo_cust() {
		return so_cust;
	}
	
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getSo_date() {
		return so_date;
	}

	public void setSo_nbr(String so_nbr) {
		this.so_nbr = so_nbr;
	}
	public void setSo_cust(String so_cust) {
		this.so_cust = so_cust;
	}
	
	public void setSo_date(Date so_date) {
		this.so_date = so_date;
	}
	
	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesOrder(String so_nbr, String so_cust, Date so_date) {
		super();
		this.so_nbr = so_nbr;
		this.so_cust = so_cust;
		this.so_date = so_date;
	}	
	
}
