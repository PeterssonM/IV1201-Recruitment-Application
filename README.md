# IV1201-Recruitment-Application
This project is a part of the course IV1201 Architecture and Design of Global Applications at KTH. Its purpose is to facilitate the recruitment process for an amusement park according to the provided requirement specification.

## Project Description  
Built with Java and Spring frameworks, this web application incorporates a database and includes features such as Spring Security. It has two types of users - applicants and recruiters, each with their respective roles. Applicants can apply for positions within the company, while recruiters manage applications. The system is divided into two parts: registration of job applications and administration of applications.
This project was developed within a seven-week timeframe, and our project group has laid a solid foundation for potential future groups to continue developing the project after the designated period. An imaginary handover of this project is part of the provided task description.

## Tools
- Git
- Maven
## Frameworks
- Spring
- Spring Boot
- Spring Web MVC
- Spring Data
- Spring-security
- Thymeleaf
## Supported Browsers
- Google Chrome
- Microsoft Edge
- Firefox
- Safari
- Opera
## Run Locally
Before attempting any of these steps, make sure you are using JAVA 17.  
1. Clone this repository to your local machine.
2. Make sure you have postgreSQL running.
3. Clone the provided database.
4. Open a command line at the root project directory and install all dependencies using this command:
```command
mvn install
```
5. Run the application:
```command
mvn spring-boot:run
```
## File Structure
### /src/main/java/com/kth/iv1201/recruitmentApp
ProjectApplication.java: Starts the application.

### /src/main/java/com/kth/iv1201/recruitmentApp/application  
ApplicationService:java: provides methods for managing job applications.   

PersonService.java: provides methods for managing user accounts.    

### /src/main/java/com/kth/iv1201/recruitmentApp/config  
ApplicationConfig.java: responsible for configuring the Spring MVC application.  

SecurityConfig.java: configuration class for Spring Security.  

ThymeleafConfig.java: configuration class for Thymeleaf template engine and view resolver.  

### /src/main/java/com/kth/iv1201/recruitmentApp/domain  
Application.java: contains information about the application.  

Availability.java: represents the availability of a user/person in the database.  

Competence.java: represents a competence in the recruitment application.  

CompetenceProfile.java: persistent class for the competence_profile database table.  

Person.java: implements the UserDetails interface from Spring Security for user authentication and authorization.  

Role.java: persistent class for the role database table.  


### /src/main/java/com/kth/iv1201/recruitmentApp/presentation
ApplicationController.java: handles all HTTP requests.  

ErrorController.java: handles all exceptions.  

### /src/main/java/com/kth/iv1201/recruitmentApp/repository
ApplicationRepository.java: Repository interface for managing entities in the database.  

AvailabilityRepository.java: Repository interface for managing entities in the database.  

CompetenceProfileRepository.java: Repository interface for managing entities in the database.  

CompetenceRepository.java: Repository interface for managing entities in the database.  

PersonRepository.java: Repository interface for managing entities in the database.  

RoleRepository.java: Repository interface for managing entities in the database.  

### /src/main/java/com/kth/iv1201/recruitmentApp/util
UserAlreadyExistException.java: handles exceptions thrown during the registration process.  

### /src/main/resources/static/css
Contains all styling involved in our webpages.  

### /src/main/resources/static/css/fragments
Contains webpage framgments.  

### /src/main/resources/static/css/image
Contains our logo.  

### /src/main/resources/templates  
Contains all project websites.  

## Project Contributors
- [Daniel Mebrahtu](https://github.com/Danielmebrahtu)
- [Maximilian Petersson](https://github.com/PeterssonM)
