package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Demo;



@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>{
	
	@Query(value ="select * from netflex",nativeQuery=true)
	public Page<Demo> findDemo(Pageable pageable);

}
