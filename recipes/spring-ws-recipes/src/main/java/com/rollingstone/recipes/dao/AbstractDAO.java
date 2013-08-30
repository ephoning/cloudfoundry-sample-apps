package com.rollingstone.recipes.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.rollingstone.recipes.utils.HibernateUtil;

/*
 * Author Binit Datta
 * 
 * Base class for all our DAOs
 */

public abstract class AbstractDAO {
	/**
	 * Autowired instance of HibernateUtil
	 */
	protected HibernateUtil hbUtil;


	public HibernateUtil getHbUtil() {
		return hbUtil;
	}

	@Autowired
	@Required
	public void setHbUtil(HibernateUtil hbUtil) {
		this.hbUtil = hbUtil;
	}
}
