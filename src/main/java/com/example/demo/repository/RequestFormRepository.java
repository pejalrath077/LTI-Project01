package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RequestForm;



@Repository
public interface RequestFormRepository extends JpaRepository<RequestForm, Long>{
	
	@Query(value ="select * from ifulfill db where LOWER(db.system) LIKE LOWER(:keyword) OR LOWER(db.criticality) LIKE LOWER(:keyword)"
			+ "OR LOWER(db.issues) LIKE LOWER(:keyword) OR LOWER(db.status) LIKE LOWER(:keyword)"
			+ "OR LOWER(db.remark) LIKE LOWER(:keyword) ",nativeQuery=true)
	public Page<RequestForm> findIfulfills(Pageable pageable,String keyword);
	public void deleteBySrNo(int id);
	public Optional<RequestForm> findBySrNo(int srNo);

	
}
