package vadel.com.projectrdvmedical.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.entity.Medecin;
import vadel.com.projectrdvmedical.repository.MedecinRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMedecin implements IServiceMedecin {
    private final MedecinRepository medecinRepository;


    @Override
    public Medecin addMedcin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> allMedecin() {
        return medecinRepository.findAll();
    }
}
