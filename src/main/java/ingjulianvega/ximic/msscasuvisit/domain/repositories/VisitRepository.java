package ingjulianvega.ximic.msscasuvisit.domain.repositories;

import ingjulianvega.ximic.msscasuvisit.domain.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface VisitRepository extends JpaRepository<VisitEntity, UUID>, JpaSpecificationExecutor<VisitEntity> {
    List<VisitEntity> findByPatientId(UUID patientId);

    List<VisitEntity> findByCreatedDateBetween(Timestamp iniDate,Timestamp endDate);

    List<VisitEntity> findByDiseaseId(UUID diseaseId);
}
