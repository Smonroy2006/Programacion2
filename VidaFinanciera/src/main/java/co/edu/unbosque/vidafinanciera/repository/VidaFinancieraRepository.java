package co.edu.unbosque.vidafinanciera.repository;

import co.edu.unbosque.vidafinanciera.model.VidaFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidaFinancieraRepository extends JpaRepository<VidaFinanciera, String> {
}
