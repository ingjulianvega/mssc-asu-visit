package ingjulianvega.ximic.msscasuvisit.services;


import ingjulianvega.ximic.msscasuvisit.web.model.Visit;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitList;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface VisitService {
    VisitList get();

    VisitDto getById(UUID id);

    VisitList getByPatientId(UUID patientId);

    VisitList getByDiseaseId(UUID diseaseId);

    VisitList getByCreatedDate(OffsetDateTime createdDate);

    void create(Visit visit);

    void updateById(UUID id, Visit visit);

    void deleteById(UUID id);


}
