package com.crudop1.students;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {

	StudentRepository repo = new StudentRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getStudents() {
		return repo.getAllStudents();
	}
	
	
	@GET
	@Path("getstudent/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getSingleStudent(@PathParam("id") String id) {
		return repo.getStudent(id);
	}
	
	
	@POST
	@Path("createStudent")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String createStudent(Student a) {
		return repo.create(a);
	}
	
	
	@PUT
	@Path("updateStudent")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String updateStudent(Student a) {
		if(repo.getStudent(a.getStudent_no()).getStudent_no()==null) {
			return repo.create(a);
		}
		else {
			return repo.update(a);
		}
		
	}
	
	@DELETE
	@Path("deleteStudent/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String deleteStudent(@PathParam("id") String id) {
		Student a = repo.getStudent(id);
		if(a.getStudent_no()!=null) {
			return repo.delete(id);
		}
		else {
			return "Record Not Found";
		}
	}
	
}
