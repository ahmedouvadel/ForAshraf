package vadel.com.projectrdvmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.com.projectrdvmedical.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
