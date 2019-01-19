# Basketball Reference
---
Project Instruction

This application is developed using Spring Boot, Spring Data, Spring RESTful web services, Maven, PostgreSql, Docker,ActiveMQ.

### Assumptions
---
1. Users are provided player and team informations based on the authorities.
2. The users information need to be created before searching.
3. The relation between team and player is "One to Many".

### Approach
---
1. Created User, Team, Player, and Player Statistics object, and created related table and col in the database.
2. The relation between Team and Player is One to Many, the team_id will be the f_k and will be stored in the player table.



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

     
    create database baskerballDB_Demo_unit
    
    \q
    
5. Schema migration for creating tables in database
     ```
     mvn compile flyway:migrate -P prod -Ddb_url={localhost:5432/basketballDB_Demo} -Ddb_password={password} -Ddb_username={admin}
     ```
     ```
     mvn compile flyway:migrate -P unit -Ddb_url={localhost:5432/basketballDB_Demo_unit} -Ddb_password={password} -Ddb_username={admin}
     ```
6.  Run the Seeding function to seed venue data in to the seat table.
    ```
    mvn clean compile exec:java -Dspring.profiles.active={prod} -Ddb.url={localhost} -Ddb.port={5432} -Ddb.dName={basketballDB_demo} -Ddb.username={admin} -Ddb.password={password}
	```
7. Package and Run the WebService jar type file to spin up the TicketService
    ```
    mvn compile package -DskipTests=true && java -jar -Dspring.profiles.active={prod} -Ddb.url={localhost} -Ddb.port={5432} -Ddb.dName={basketballDB_demo} -Ddb.username={admin} -Ddb.password={password} target/ticketservice-1.0-SNAPSHOT.jar  
    ```
