package com.dummy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.beans.Credentials;
import com.dummy.service.CredentialsServiceImpl;

@RestController
@RequestMapping(value="/creds")
public class CredentialsController {
	
	
	private CredentialsServiceImpl csi = new CredentialsServiceImpl();
	
	
//	@GetMapping("/api/employees/{id}")
//	@ResponseBody
//	public String getEmployeesById(@PathVariable String id) {
	
	
	@RequestMapping(value="/addCreds", method=RequestMethod.POST)
	public ResponseEntity<String> createCreds(Credentials creds){
		Credentials c = null;
		ResponseEntity<String> resp = null;
		try {
			
			csi.createCreds(creds);
			resp = new ResponseEntity<>("Attempt UPDATED SUCCESSFULLY", HttpStatus.OK);

		}  catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE Attempt", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}

	@PostMapping(value="/updateCreds")
	public ResponseEntity<String> updateCreds(Credentials creds){
		ResponseEntity<String> resp = null;

try {
			csi.updateCreds(creds);;
			resp = new ResponseEntity<>("Attempt UPDATED SUCCESSFULLY", HttpStatus.OK);

		}  catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE Attempt", HttpStatus.BAD_REQUEST);
		}

		return resp;
	}
	
	
	
	
	@GetMapping(value="/viewAllCreds")
	public ResponseEntity<List<Credentials>> viewAllCreds(){
		List<Credentials> credList = new ArrayList<>();
		credList.add(new Credentials("DID NOT WORK","Try AGAIN"));
		ResponseEntity<List<Credentials>> resp = null;
try {
			resp = new ResponseEntity<>(csi.viewAllCreds(), HttpStatus.OK);

		}  catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>(credList, HttpStatus.BAD_REQUEST);

		}
		
		return resp;
	}
	
}
