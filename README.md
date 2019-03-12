# spring-boot-user
Spring Boot user login and registration module with JWT Authentication
# ---------------------------------------------------------------------<br/>

# User Module <br/>
Register :<br/>
<br/>
API Endpoint : "base_url"/register<br/>
Request Method : POST<br/>
POST Body :<br/>
          {<br/>
            "firstName": "Tyrion", <br/>
            "lastName": "Lannister", <br/>
            "email": "tyrion.casterly_rock@got.com", <br/>
            "password": "handofthequeen", <br/>
            "username": "tyrion_lannister"<br/>
          }<br/>
(username should be unique)<br/>
<br/>
Response :<br/>
Successful Registration : 200 OK<br/>
Registration Failure : 500 Server Error (in case of user existed with same username)<br/>
<br/>
# ---------------------------------------------------------------------<br/>
<br/>
Login :<br/>
API Endpoint : "base_url"/login<br/>
Request Method : POST<br/>
POST Body :<br/>
          { <br/>
             "username": "tyrion_lannister", <br/>
             "password": "handofthequeen"<br/>
          }<br/>
Response :<br/>
Successful Login : 200 OK with JWT Token as "Authorization" header.<br/>
Login Failure : 403 Unauthorized<br/>
<br/>
# ---------------------------------------------------------------------<br/>

# Database Configuration<br/>
Modify the database credentials in "resources/application.properties"<br/>
<br/>
spring.jpa.hibernate.ddl-auto=update<br/>
spring.datasource.url= "Database URL" (e.g.: jdbc:mysql://localhost:3306/puc-assignment)<br/>
spring.datasource.username= "Database Username"<br/>
spring.datasource.password= "Database Password"<br/>
