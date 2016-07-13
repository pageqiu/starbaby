package com.page.st.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.Summary;
import com.page.st.mapper.SummaryDao;

@Service
public class SummaryService {
	
	@Autowired
	private MyBatisConfiguration repository;
	

	@Autowired
	private SummaryDao dao;
	
	public List<Summary> getAllSummarys() {
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();
		
		List<Summary> list = dao.getAllSummarys(ss);
		ss.clearCache();
		ss.close();
		return list;
	}


}
