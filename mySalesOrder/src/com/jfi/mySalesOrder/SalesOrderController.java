package com.jfi.mySalesOrder;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfi.mySalesOrder.domain.SalesOrder;
import com.jfi.mySalesOrder.domain.SalesOrders;
import com.jfi.mySalesOrder.service.ISalesOrderService;



@Controller
public class SalesOrderController {
	private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
	
	@Autowired
	private ISalesOrderService salesOrderService;
	
	@RequestMapping(value = "/commitSO", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE,produces={"application/json"})
	public @ResponseBody String CommitSO(@RequestBody SalesOrder salesOrder){
		logger.info("The sales order nbr is {}.", salesOrder.getSo_nbr());
		
		boolean result = salesOrderService.saveSalesOrder(salesOrder);
		
		return result?"Sucessful":"Fail";
	}
	
	@RequestMapping(value = "/findSO", method = RequestMethod.GET,produces={"application/json"})
	public @ResponseBody SalesOrder FindSO(@RequestParam("nbr") String soNbr){
		logger.info("Find sales order is {}.", soNbr);
		return salesOrderService.findSalesOrder(soNbr);	
	}
	
	@RequestMapping(value = "/browseSO", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody SalesOrders BrowseSO(@RequestParam("cust") String soCust){
		logger.info("Browse sales order is for {}.", soCust);
		return salesOrderService.browseSalesOrders(soCust);
	}
}
