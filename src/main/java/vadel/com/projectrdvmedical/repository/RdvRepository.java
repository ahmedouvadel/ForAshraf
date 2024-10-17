package vadel.com.projectrdvmedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vadel.com.projectrdvmedical.entity.Rdv;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Integer> {
}
