package vadel.com.projectrdvmedical.Service;

import vadel.com.projectrdvmedical.entity.Rdv;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IServiceRdv {
    Rdv addRdv(Rdv rdv);
    List<Rdv> allRdv();
    Rdv getRdvPatientBydateTime(int patientId, LocalDateTime dateTime);
    Rdv getRdvMedcinBydateTime(int medecinId, LocalDateTime dateTime);
    List<Rdv> getAllRdvByOrderAsc();
    List<Rdv> getRdvByMedecinAndDate(int medecinId, LocalDate date);

}
