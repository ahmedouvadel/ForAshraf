package vadel.com.projectrdvmedical.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vadel.com.projectrdvmedical.entity.Rdv;
import vadel.com.projectrdvmedical.repository.RdvRepository;

import java.util.List;

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
}
