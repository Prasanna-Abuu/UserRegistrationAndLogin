package com.kavanant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavanant.model.Patient;
import com.kavanant.repository.PatientRepository;

	@Service
	public class PatientService {

	    @Autowired
	    private PatientRepository patientRepository;

	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }

	   

	    public Patient addPatient(Patient patient) {
	        return patientRepository.save(patient);
	    }

	   
	}



