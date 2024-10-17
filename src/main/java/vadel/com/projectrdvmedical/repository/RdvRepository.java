package vadel.com.projectrdvmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vadel.com.projectrdvmedical.entity.Rdv;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Integer> {

    Rdv findRdvByPatientIdAndAndDateRdv(int patientId, LocalDateTime dateTime);
    Rdv findRdvByMedecinIdAndAndDateRdv(int medecinId, LocalDateTime dateTime);
    List<Rdv> findAllByOrderByDateRdvAsc();

    // Method to find all appointments for a doctor on a specific date
    @Query("SELECT r FROM Rdv r WHERE r.medecin.id = :medecinId AND FUNCTION('DATE', r.dateRdv) = :date")
    List<Rdv> findRdvByMedecinIdAndDate(@Param("medecinId") int medecinId, @Param("date") LocalDate date);
}
