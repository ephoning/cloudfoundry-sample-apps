package com.eddie.springframework.cloud.service.relational;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 10/14/13
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.cloud.service.common.RelationalServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("oracle")
public class OracleServiceInfo extends RelationalServiceInfo {

    /**
     * example Oracle thin driver URI : jdbc:oracle:thin:eddie/secret@localhost:1521/test
     * (assuming ojdbc14)
     *
     * @param id
     * @param uri
     */
    public OracleServiceInfo(java.lang.String id, java.lang.String uri) {
        super(id, uri, "oracle");
        System.out.println(String.format("OracleServiceInfo.<init> with %s / %s", id, uri));
        this.jdbcUrl =
                String.format("jdbc:oracle:thin:%s/%s@%s:%d/%s",
                        getUserName(), getPassword(), getHost(), getPort(), getPath());
        System.out.println(String.format("OracleServiceInfo.<init> jdbcUrl is now: %s", jdbcUrl));
    }
}





