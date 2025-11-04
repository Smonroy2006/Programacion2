package co.edu.unbosque.vidapersonalservice.repository;

import co.edu.unbosque.vidapersonalservice.model.VidaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidaPersonalRepository extends JpaRepository<VidaPersonal, String> {
}
