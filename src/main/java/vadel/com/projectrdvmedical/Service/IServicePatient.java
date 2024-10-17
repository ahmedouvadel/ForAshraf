package vadel.com.projectrdvmedical.Service;

import vadel.com.projectrdvmedical.entity.Patient;

import java.util.List;

public interface IServicePatient {
    Patient addPatient(Patient patient);
    List<Patient> allPatient();

}
