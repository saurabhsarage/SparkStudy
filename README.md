# assignment
### JDK Version :- 8
### Mysql Workbench Version :- 8.0.22

For Accesing URL Postman is Used

### TO get All Data From database use URL
#### This Uses GET Method TO access Data From Database
http://localhost:8080/students/webapi/students

### To Retrive Single Data From Database
#### This Uses GET Method
http://localhost:8080/students/webapi/students/getstudent/<Student_no Here>

### To Insert Data In database 
#### This Uses Post Method 
http://localhost:8080/students/webapi/students/createStudent
Data Format Can Be as follows
##### For JSON 
{
        "student_dob": "1997-03-13",
        "student_doj": "2021-01-22",
        "student_name": "Dhoom",
        "student_no": "A12"
    }
##### For XML
<student>
        <student_dob>1997-03-13</student_dob>
        <student_doj>2021-01-22</student_doj>
        <student_name>Pankaj</student_name>
        <student_no>A11</student_no>
    </student>
    
 ### For Updating It Uses PUT Method
 http://localhost:8080/students/webapi/students/updateStudent
 Data Format Can Be as follows
##### For JSON 
{
        "student_dob": "1997-03-13",
        "student_doj": "2021-01-22",
        "student_name": "Dhoom",
        "student_no": "A12"
    }
##### For XML
<code>
    < student >
        < student_dob >1997-03-13</ student_dob >
        < student_doj >2021-01-22</ student_doj >
        < student_name >Pankaj</ student_name >
        < student_no >A11</ student_no >
    </ student >
 </code>
 
 ### For Delete student Data DELETE Method Use
 http://localhost:8080/students/webapi/students/deleteStudent/<Student_no Here>
