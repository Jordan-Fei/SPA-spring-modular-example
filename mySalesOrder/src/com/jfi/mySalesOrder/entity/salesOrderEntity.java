package com.jfi.mySalesOrder.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "so_mstr")
public class salesOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "so_id", nullable = false)
    private Long so_id;
    
    @Column(name = "so_nbr", nullable = false)
    private String so_nbr;
    
    public String getSo_nbr() {
		return so_nbr;
	}

	public void setSo_nbr(String so_nbr) {
		this.so_nbr = so_nbr;
	}

	public String getSo_cust() {
		return so_cust;
	}

	public void setSo_cust(String so_cust) {
		this.so_cust = so_cust;
	}

	public Date getSo_date() {
		return so_date;
	}

	public void setSo_date(Date so_date) {
		this.so_date = so_date;
	}

	public Long getSo_id() {
		return so_id;
	}

	public long getVersion() {
		return version;
	}

	@Column(name = "so_cust", nullable = false)
    private String so_cust;
    
    @Column(name = "so_date", nullable = false)
    private Date so_date;
    
    @Version
    private long version = 0;    

}
