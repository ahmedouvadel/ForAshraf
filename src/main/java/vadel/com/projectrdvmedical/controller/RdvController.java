package vadel.com.projectrdvmedical.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vadel.com.projectrdvmedical.Service.IServiceRdv;
import vadel.com.projectrdvmedical.entity.Rdv;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class RdvController {
    private final IServiceRdv serviceRdv;


    @GetMapping("/rdv")
    public ResponseEntity<List<Rdv>> getAllRdv(){
        List<Rdv> rdvList = serviceRdv.getAllRdvByOrderAsc();
        return new ResponseEntity<>(rdvList, HttpStatus.ACCEPTED);
    }

    @PostMapping("/rdv")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public ResponseEntity<Object> addRdv(@RequestBody Rdv rdv){
        Rdv existRdvPatient = serviceRdv.getRdvPatientBydateTime(rdv.getPatient().getId(),rdv.getDateRdv());
        Rdv existRdvMedecin = serviceRdv.getRdvMedcinBydateTime(rdv.getMedecin().getId(), rdv.getDateRdv());

        if(existRdvPatient != null){
            return  new ResponseEntity<>("Patient Already has an appointment at this time" , HttpStatus.CONFLICT);
        }
        if(existRdvMedecin != null){
            return  new ResponseEntity<>("Patient Already has an appointment at this time" , HttpStatus.CONFLICT);
        }

        Rdv rdv1 = serviceRdv.addRdv(rdv);
        return new ResponseEntity<>(rdv1, HttpStatus.CREATED);
    }

    @GetMapping("/rdv/medecin")
    public ResponseEntity<List<Rdv>> getRdvByMedecinAndDate(
            @RequestParam int medecinId,
            @RequestParam String date) {

        // Convert the date string to LocalDate
        LocalDate localDate = LocalDate.parse(date);

        // Call the service to get the list of appointments
        List<Rdv> rdvList = serviceRdv.getRdvByMedecinAndDate(medecinId, localDate);

        if (rdvList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rdvList, HttpStatus.OK);
    }

}
