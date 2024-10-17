package vadel.com.projectrdvmedical.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.com.projectrdvmedical.Service.IServiceMedecin;
import vadel.com.projectrdvmedical.entity.Medecin;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class MedecinController {

    private final IServiceMedecin serviceMedecin;

    @GetMapping("/medecin")
    public ResponseEntity<List<Medecin>> getAllMedecin(){
        List<Medecin> allamedecin =  serviceMedecin.allMedecin();
        return new ResponseEntity<>(allamedecin,HttpStatus.CREATED);
    }

    @PostMapping("/medecin")
    public ResponseEntity<Medecin> addMadecin(@RequestBody Medecin medecin){
        Medecin medecin1 = serviceMedecin.addMedcin(medecin);
        return new ResponseEntity<>(medecin1, HttpStatus.ACCEPTED);
    }
}
