package com.kavanant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kavanant.model.Patient;
import com.kavanant.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

   
   
    @PostMapping("/patient/add")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
         patientService.addPatient(patient);
        return ResponseEntity.status(201).body("Patient Created Successfully ");
    }

    
    
   
    @GetMapping("/patient/getall")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

   
}
