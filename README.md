# Basketball Reference
---
Project Instruction

This application is developed using Spring Boot, Spring Data, Spring RESTful web services, Maven, PostgreSql, Docker, Amazon SQS, Amazon S3.

### Assumptions
---
1. Users are provided player and team informations based on the authorities.
2. The users information need to be created before searching.
3. The relation between team and player is "One to Many", the relationship between player and player statistics is "One to One".

### Approach
---
1. Created User, Team, Player, and Player Statistics object, and created related table and col in the database.
2. The relation between Team and Player is One to Many, the team_id will be the foregin key and will be stored in the player table.
3. The relation between Player and Player Statistics is One to One, the player_id will be the foregin key and will be stored in the player statistics table.



### Building Project
---
1. Clone the project
	
	```
	git clone https://github.com/xchris1015/basketball
	```
2. Install docker if needed.

3. Open a new command line window and Spin up the PostgreSql database server using Postgres docker image
    ```
    docker pull postgres
    ```
    ```
    docker run --name {BasketballDB_Demo} -e POSTGRES_DB={basketballDB_Demo} -e POSTGRES_USER={username} -e POSTGRES_PASSWORD={password} -p 5432:5432 -d postgres
   ```
4. Create Unit database for unit testing
     ```
     psql -h localhost -U {username} -d postgres;
     ```
     Type password: password     
     ```
     create database baskerballDB_Demo_unit
     \q
     ```
### Database Migration
---
5. Schema migration for creating tables in database
     ```
     mvn compile flyway:migrate -P dev -Ddb_url={localhost:5432/basketballDB_Demo} -Ddb_password={password} -Ddb_username={admin}
     ```
     ```
     mvn compile flyway:migrate -P unit -Ddb_url={localhost:5432/basketballDB_Demo_unit} -Ddb_password={password} -Ddb_username={admin}
     ```
     
### Testing Results
---
6. Tests are done using JUnit and Mockito. Tests are run using the command

     ```
     mvn compile test -Dspring.profiles.active={unit} -Ddb.url={localhost} -Ddb.port={5432} -Ddb.dName={basketball_unit} -Ddb.username={admin} -Ddb.password={password}
     ```

### Package
---
7. Package and Run the Basketball jar type file to spin up the Basketball Reference
    ```
    mvn compile package -DskipTests=true && java -jar -Dspring.profiles.active={dev} -Ddb.url={localhost} -Ddb.port={5432} -Ddb.dName={basketballDB_demo} -Ddb.username={admin} -Ddb.password={password} target/basketball-1.0-SNAPSHOT.jar  
    ```

### BasketballReferenceDemo
---

1.  User sign up to get email 
    ```
    POST - http://localhost:8080/api/user/signup
    ```
    Requestbody
    ```
    {
      "firstName" : "Chris",
      "lastName" : "Paul",
      "email":"xpaul@gmail.com"
    }
    ``` 

2. User Login with Token 
	
		POST - http://localhost:8080/api/user/login
   
   ResponseEntity:
	
		{
		"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ4Y2hyaXMyMCIsImF1ZGllbmNlIjoid2ViIiwidXNlcl9jcmVhdGVkX2F0IjoxNTQ1NDI2MjUxMTYzLCJjcmVdGVkIjoxNTQ3OTMyNjI4NTUzLCJleHAiOjE1NDgwMTkwMjh9.wosIv6mGFxR4exxfjtVkwRBM_VNrToaw709AB88mnuO_Ha5AVz7U4Y5bWoWJSSRdDA4HD3pIiVwq2WlioI6dQ"
		}
3. Input the JwtToken with Serect Key and use findByFirstName pass the User last name by using @PathParam.
    
        GET - http://localhost:8080/api/user/?first_name=Chris  
    
    ResponseEntity:
	
        {
            "id": 251,
            "username": "xchris",
            "firstName": "Chris",
            "lastName": "Xu",
            "email": "xchris1015@gmail.com",
            "authorities": null
        }
        


### Todo List In The Future
---
