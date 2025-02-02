## Student Management System
### Student_table
- Rollno(PK)
- Name
- ClassNumber
- Section
- Percentage
### Dependencies
- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver
- Spring Web

### REST End Points
 - GET : localhost:8080/studapi/students
	 - To fetch all students.
- GET : localhost:8080/studapi/student/{id}
    - To fetch student using student roll no.
- POST : localhost:8080/studapi/create
     - To save new student to database.
- PUT : localhost:8080/studapi/update/{id}
   - To update student details based on roll no.
- DELETE : localhost:8080/studapi/delete/{id}
   - To delete student based on student roll no.
