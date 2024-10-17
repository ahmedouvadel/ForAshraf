package vadel.com.projectrdvmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.com.projectrdvmedical.entity.Medecin;
@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Integer> {
}
