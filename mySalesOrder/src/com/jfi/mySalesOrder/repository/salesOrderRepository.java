package com.jfi.mySalesOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfi.mySalesOrder.entity.salesOrderEntity;

public interface salesOrderRepository extends JpaRepository<salesOrderEntity, Long> {
	@Query("select s from salesOrderEntity s where LOWER(s.so_nbr) = LOWER(:soNbr)")
	public List<salesOrderEntity> find(@Param("soNbr") String soNbr);
	
	@Query("select s from salesOrderEntity s where s.so_cust LIKE %:soCust% OR :soCust = ''")
	public List<salesOrderEntity> browse(@Param("soCust") String soCust);

}
