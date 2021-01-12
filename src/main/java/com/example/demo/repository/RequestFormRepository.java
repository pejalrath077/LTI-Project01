package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RequestForm;



@Repository
public interface RequestFormRepository extends JpaRepository<RequestForm, Long>{
	
	@Query(value ="select * from ifulfill",nativeQuery=true)
	public Page<RequestForm> findIfulfills(Pageable pageable);

}
