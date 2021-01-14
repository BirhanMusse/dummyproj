package com.dummy.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.DAO.StudentDAOImpl;
import com.dummy.beans.Credentials;
import com.dummy.beans.Student;
import com.dummy.service.CredentialsServiceImpl;
import com.dummy.service.StudentServiceImpl;

@RestController
public class StudentController {

	private StudentServiceImpl ss = new StudentServiceImpl();
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents (){
			return new ResponseEntity<>(ss.getAllStudents(),HttpStatus.OK);


	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student s){
			ResponseEntity<String> resp = null;
			try {
				ss.addStudent(s);
				resp = new ResponseEntity<>("Attempt UPDATED SUCCESSFULLY", HttpStatus.OK);

			}  catch (Exception e) {
				resp = new ResponseEntity<>("FAILED TO UPDATE Attempt", HttpStatus.BAD_REQUEST);

			}
			
			return resp;
}
	
	@RequestMapping(value="/update", method= RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@RequestBody Student s){
		ResponseEntity<String> resp = null;
		try {
			ss.updateStudent(s);
			resp = new ResponseEntity<>("Attempt UPDATED SUCCESSFULLY", HttpStatus.OK);

		}  catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE Attempt", HttpStatus.BAD_REQUEST);

		}
		return resp;
	}
}
