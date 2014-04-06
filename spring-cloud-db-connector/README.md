This sample demonstrates how [Spring Cloud](https://github.com/spring-projects/spring-cloud) can be extended with support for another database.

The following classes have to be implemented:
* a class extending ```org.springframework.cloud.cloudfoundry.RelationalServiceInfoCreator```; This class is responsible for implementing functionality to:
** provide access to a ```RelationalServiceInfo``` instance (in our example Oracle implementation, we return an OracleServiceInfo instance)
** provide decision logic (method: accept), used the Spring Cloud framework whether to delegate the creation of key datasource configuration information, such as the connection URI, to this specific implementation; in our example Oracle implementation, we decide on the basis of the presence of the string ‘oracle’ in the ‘name’ field of the set of key/value pair specified when defining a user-defined service instance
* a class extending ```org.springframework.cloud.service.common.RelationalServiceInfo```. This class is responsible for implementing functionality to:
** construct a jdbcUrl, given access - through getter methods - to the set of key/value pairs that were used to define an instance of this service (specifically: host, port, user, password, and name); in our example Oracle implementation, we compose a thin driver URI that is compatible with
that as expected by ojdbc14
* a class extending ```org.springframework.cloud.service.relational.DataSourceCreator```. Thisclass is responsible for implementing functionality to:
** provide the name of the (jdbc) driver to use; in our Oracle example, we return the FQN of the thin driver: ```oracle.jdbc.driver.OracleDriver```
** provide a validation query; in our Oracle example, we use an Oracle standard approach: ‘SELECT 1 FROM DUAL’

Additionally, the following resource files have to be defined:
* a file named ```org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator``` This file contains the name of the class extending the RelationServiceInfoCreator class (in our Oracle example implementation, we use ‘com.eddie.springframework.cloud.server.relational.OracleServiceInfoCreator’)
* a file named ```org.springframework.cloud.service.ServiceConnectorCreator``` This file contains the name of the class extending the RelationServiceInfo class (in our Oracle example implementation, we use ‘com.eddie.springframework.cloud.server.relational.OracleDataSourceCreator’)

These resource files provide the registration mechanism: presence of these explicitly named files on the classpath allows the Spring Cloud framework to find the classes that define our implementation; in our Oracle example implementation, note that both class ‘OracleDataSourceCreator’ and ‘OracleServiceInfoCreator’ are parameterized with class ‘OracleServiceInfo’, hence all 3 required implementation classes are, once registered, “in scope” of Spring Cloud framework)

