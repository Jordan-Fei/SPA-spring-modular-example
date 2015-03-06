package com.jfi.mySalesOrder.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfi.mySalesOrder.domain.SalesOrder;
import com.jfi.mySalesOrder.domain.SalesOrders;
import com.jfi.mySalesOrder.entity.salesOrderEntity;
import com.jfi.mySalesOrder.repository.salesOrderRepository;

@Service(value="ISalesOrderService")
public class SalesOrderService implements ISalesOrderService {
	
    @Resource
    private salesOrderRepository soRepository;

    @Transactional
	@Override
	public boolean saveSalesOrder(SalesOrder so) {
		// TODO Auto-generated method stub
    	salesOrderEntity soEntity = new salesOrderEntity();
    	soEntity.setSo_nbr(so.getSo_nbr());
    	soEntity.setSo_cust(so.getSo_cust());
    	soEntity.setSo_date(so.getSo_date());
    	
    	this.soRepository.save(soEntity);
		return true;
	}

	@Override
	public SalesOrder findSalesOrder(String soNbr) {
		SalesOrder so = null;
		List<salesOrderEntity> soList = soRepository.find(soNbr);
		if(!soList.isEmpty()){
			so = new SalesOrder();
			salesOrderEntity soEntity = soList.get(0);
			so.setSo_nbr(soEntity.getSo_nbr());
			so.setSo_cust(soEntity.getSo_cust());
			so.setSo_date(soEntity.getSo_date());
		}
		return so;
	}

	@Override
	public SalesOrders browseSalesOrders(String soCust) {
		SalesOrders SOs = new SalesOrders();
		List<salesOrderEntity> soList = this.soRepository.browse(soCust);
		for(salesOrderEntity soEntity:soList){
			SalesOrder so = new SalesOrder();
			so.setSo_nbr(soEntity.getSo_nbr());
			so.setSo_cust(soEntity.getSo_cust());
			so.setSo_date(soEntity.getSo_date());
			SOs.add(so);
		}
		
		return SOs;
	}

}
