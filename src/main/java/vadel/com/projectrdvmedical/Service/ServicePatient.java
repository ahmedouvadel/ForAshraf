package vadel.com.projectrdvmedical.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.entity.Patient;
import vadel.com.projectrdvmedical.repository.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePatient implements IServicePatient {

    private final PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> allPatient() {
        return patientRepository.findAll();
    }
}
