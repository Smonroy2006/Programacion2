package co.edu.unbosque.VidaAcademicaService.repository;

import co.edu.unbosque.VidaAcademicaService.model.VidaAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VidaAcademicaRepository extends JpaRepository<VidaAcademica,String> {
}
