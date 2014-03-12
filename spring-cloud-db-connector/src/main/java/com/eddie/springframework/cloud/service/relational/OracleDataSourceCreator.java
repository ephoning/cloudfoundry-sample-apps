package com.eddie.springframework.cloud.service.relational;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 10/14/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.cloud.service.relational.DataSourceCreator;

public class OracleDataSourceCreator extends DataSourceCreator<OracleServiceInfo> {

    private static final String VALIDATION_QUERY = "SELECT 1 FROM DUAL";

    @Override
    public String getDriverClassName() {
        System.out.println("OracleDataSourceCreator.getDriverClassName...");
        return "oracle.jdbc.driver.OracleDriver";
    }

    @Override
    public String getValidationQuery() {
        System.out.println("OracleDataSourceCreator.getValidationQuery...");
        return VALIDATION_QUERY;
    }

}
