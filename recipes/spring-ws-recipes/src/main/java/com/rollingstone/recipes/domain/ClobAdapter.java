package com.rollingstone.recipes.domain;

import java.sql.Clob;
import java.sql.SQLException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.log4j.Logger;
import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.mapping.ValidityException;

/*
 * Author Binit Datta
 * 
 * As we are using Clob, this class needed by the marshaler to help marshal Clob objects to and from xml
 */
public class ClobAdapter extends XmlAdapter<String, Clob> implements FieldHandler{

	Logger logger = Logger.getLogger(ClobAdapter.class);
	Clob clob;
    @Override
    public Clob unmarshal(String v) throws Exception {
    	try{
    		clob = org.hibernate.Hibernate.createClob(v);
    	}catch(Exception e){
    		logger.error(e.getMessage());
    	}
    	return clob;
    }

    @Override
    public String marshal(Clob v) throws Exception {
    	return v.getSubString(1, (int) v.length());
    }

	@Override
	public void checkValidity(Object arg0) throws ValidityException,
			IllegalStateException {
	}

	@Override
	public Object getValue(Object arg0) throws IllegalStateException {
		Recipe recipe = (Recipe)arg0;
		Clob clob = recipe.getProcess();
		String str = null;
		try {
			str = clob.getSubString(1, (int) clob.length());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return str;
	}

	@Override
	public Object newInstance(Object arg0) throws IllegalStateException {
		return null;
	}

	@Override
	public void resetValue(Object arg0) throws IllegalStateException,
			IllegalArgumentException {
	}
	
	@Override
	public void setValue(Object arg0, Object arg1)
			throws IllegalStateException, IllegalArgumentException {
		Recipe rcp = (Recipe)arg0;
    	try {
    		clob = org.hibernate.Hibernate.createClob((String)arg1);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
			
    	rcp.setProcess(clob);
	}
}