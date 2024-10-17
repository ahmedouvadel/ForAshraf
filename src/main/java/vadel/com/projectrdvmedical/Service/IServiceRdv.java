package vadel.com.projectrdvmedical.Service;

import vadel.com.projectrdvmedical.entity.Rdv;

import java.util.List;

public interface IServiceRdv {
    Rdv addRdv(Rdv rdv);
    List<Rdv> allRdv();
}
