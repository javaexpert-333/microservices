package com.javaexpert.bankrates.service;

import org.springframework.stereotype.Service;

import com.javaexpert.bankrates.model.CrossRate;

@Service
public class CrossRateServiceImpl implements CrossRateService {

	@Override
	public CrossRate calculateCrossRate(CrossRate crossRate) {
		if(crossRate.getFromCcy().equals(crossRate.getToCcy())) {
			crossRate.setCrossRate(1);
		} else {
			crossRate.setCrossRate(10.345);
		}
		return crossRate;
	}

}
