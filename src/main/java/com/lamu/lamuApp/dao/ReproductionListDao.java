package com.lamu.lamuApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lamu.lamuApp.model.ReproductionList;

public interface ReproductionListDao extends CrudRepository<ReproductionList, Long>{
	List<ReproductionList> findByClient(Long client);
}
