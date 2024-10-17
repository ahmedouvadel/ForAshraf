package vadel.com.projectrdvmedical.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.entity.Rdv;
import vadel.com.projectrdvmedical.repository.RdvRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceRdv implements IServiceRdv {

    private final RdvRepository rdvRepository;

    @Override
    public Rdv addRdv(Rdv rdv) {
        return rdvRepository.save(rdv);
    }

    @Override
    public List<Rdv> allRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv getRdvPatientBydateTime(int patientId, LocalDateTime dateTime) {
        return rdvRepository.findRdvByPatientIdAndAndDateRdv(patientId,dateTime);
    }

    @Override
    public Rdv getRdvMedcinBydateTime(int medecinId, LocalDateTime dateTime) {
        return rdvRepository.findRdvByMedecinIdAndAndDateRdv(medecinId,dateTime);
    }

    @Override
    public List<Rdv> getAllRdvByOrderAsc() {
        return rdvRepository.findAllByOrderByDateRdvAsc();
    }

    @Override
    public List<Rdv> getRdvByMedecinAndDate(int medecinId, LocalDate date) {
        return rdvRepository.findRdvByMedecinIdAndDate(medecinId, date);
    }


}
