package com.jfi.mySalesOrder.service;

import com.jfi.mySalesOrder.domain.SalesOrder;
import com.jfi.mySalesOrder.domain.SalesOrders;

public interface ISalesOrderService {
	boolean saveSalesOrder(SalesOrder so);
	
	SalesOrder findSalesOrder(String soNbr);
	
	SalesOrders browseSalesOrders(String soCust);

}
