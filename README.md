# IV1201-Recruitment-Application
This project is a part of the course IV1201 Architecture and Design of Global Applications at KTH. Its purpose is to facilitate the recruitment process for an amusement park according to the provided requirement specification.
##Project Description
This student kth...
##Tools
- Git
- Maven
##Frameworks
- Spring
- Spring Boot
- Spring Web MVC
- Spring Data
- Spring-security
- Thymeleaf
##Supported Browsers
- Google Chrome
- Microsoft Edge
- Firefox
- Safari
- Opera
##Run Locally
Before attempting any of these steps, make sure you are using JAVA 17.  
1. Clone this repository to your local machine.
2. Make sure you have postgreSQL running.
3. Clone the provided database.
4. Add a new table into your database by running this SQL script:  
```postgreSQL
CREATE TABLE application (
    application_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    person_id INTEGER NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    from_date DATE,
    to_date DATE,
    years_of_experience NUMERIC(4,2),
    competence_id INTEGER,
    PRIMARY KEY (application_id)
);

INSERT INTO application (person_id, name, surname, from_date, to_date, years_of_experience, competence_id)
SELECT
    p.person_id,
    p.name,
    p.surname,
    a.from_date,
    a.to_date,
    cp.years_of_experience,
    cp.competence_id
FROM
    person p
    JOIN availability a ON p.person_id = a.person_id
    JOIN competence_profile cp ON p.person_id = cp.person_id;  
```
5. Add a column to the newly generated table by running this SQL script:  
```postgreSQL
ALTER TABLE application ADD COLUMN status VARCHAR(255) DEFAULT 'unhandled';
```
6. Open a command line at the root project directory and install all dependencies using this command:
```command
mvn install
```
7. Run the application:
```command
mvn spring-boot:run

##File Structure
