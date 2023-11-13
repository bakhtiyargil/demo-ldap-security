# demo-ldap-security

The demo application is used to test Spring Security features with
Active Directory (OpenLDAP)-integrated Keycloak in Java using Spring Boot.

* First you need to make sure that your OpenLdap and Keycloak servers are up and running.
    * You can find docker-compose file under the `/infra` package that will help you with above stuff.
* Customize the newly created LDAP server by adding users and user groups accordingly, either using LDIF files or by
  manual.
    * E.g. <br/>
      Root organisation:
      ![img.png](img.png)
      User groups:
      ![img_1.png](img_1.png)
      Users:
      ![img_2.png](img_2.png)
      And you are done with the LDAP server.