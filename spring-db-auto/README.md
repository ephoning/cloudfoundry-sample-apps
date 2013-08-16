Minimalistic Java Spring Web Application - Auto Configuration
========================================
A tiny web application that relies on having been bound to a DB service as provided by Cloud Foundry; specifically *cleardb*.

It relies on the **Auto-Configuration** support for a service binding as described in http://docs.cloudfoundry.com/docs/using/services/spring-service-bindings.html.

Once pushed to Cloud Foundry (and bound to, say, cleardb), the root URL show a simple 'hello world' message. Browsing to .../db-test will show the validity of the defined Spring datasource bean and the resul of a simple DB access test (the number of records in the table that has been created and populated at application start-up).

Note the dependency on *cleardb*, as per the dependency on the MySQL connector defined in the application project's Maven **pom.xml** file.
