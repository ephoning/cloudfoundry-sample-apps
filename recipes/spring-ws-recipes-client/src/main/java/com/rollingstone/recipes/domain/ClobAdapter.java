package com.rollingstone.recipes.domain;

import java.sql.Clob;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ClobAdapter extends XmlAdapter<String, Clob> {

	Clob clob = null;
    @Override
    public Clob unmarshal(String v) throws Exception {
    	long position = 1;
    	clob.setString(position, v);
    	return clob;
    }

    @Override
    public String marshal(Clob v) throws Exception {
    	return v.toString();
    }

}