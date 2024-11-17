package vadel.com.projectrdvmedical.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vadel.com.projectrdvmedical.Service.IServicePatient;
import vadel.com.projectrdvmedical.entity.Patient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class PatientController {
    private final IServicePatient servicePatient;

    @GetMapping("/patient")
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patientList = servicePatient.allPatient();
        return new ResponseEntity<>(patientList, HttpStatus.ACCEPTED);
    }

    @PostMapping("/patient")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient patient1= servicePatient.addPatient(patient);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }
}
