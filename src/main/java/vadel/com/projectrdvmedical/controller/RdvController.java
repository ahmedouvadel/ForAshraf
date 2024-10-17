package vadel.com.projectrdvmedical.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vadel.com.projectrdvmedical.Service.IServiceRdv;
import vadel.com.projectrdvmedical.entity.Rdv;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class RdvController {
    private final IServiceRdv serviceRdv;

    @GetMapping("/rdv")
    public ResponseEntity<List<Rdv>> getAllRdv(){
        List<Rdv> rdvList = serviceRdv.allRdv();
        return new ResponseEntity<>(rdvList, HttpStatus.ACCEPTED);
    }

    @PostMapping("/rdv")
    public ResponseEntity<Rdv> addRdv(@RequestBody Rdv rdv){
        Rdv rdv1 = serviceRdv.addRdv(rdv);
        return new ResponseEntity<>(rdv1, HttpStatus.CREATED);
    }
}
