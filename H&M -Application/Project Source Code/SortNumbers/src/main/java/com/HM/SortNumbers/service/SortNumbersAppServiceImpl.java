package com.HM.SortNumbers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HM.SortNumbers.dao.SortNumbersAppDao;

@Service
public class SortNumbersAppServiceImpl implements SortNumbersAppService{

	@Autowired
	SortNumbersAppDao sortNumbersAppDao;

	@Override
	public String sortNumbers(String numberVal){

		return sortNumbersAppDao.sortNumbers(numberVal);

	}


}