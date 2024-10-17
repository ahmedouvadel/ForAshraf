package vadel.com.projectrdvmedical.Service;

import vadel.com.projectrdvmedical.entity.Medecin;

import java.util.List;

public interface IServiceMedecin {

    Medecin addMedcin(Medecin medecin);
    List<Medecin> allMedecin();

}
