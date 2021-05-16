package ingjulianvega.ximic.msscasuvisit.web.controller;


import ingjulianvega.ximic.msscasuvisit.services.VisitService;
import ingjulianvega.ximic.msscasuvisit.web.model.Visit;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class VisitController implements VisitI {

    private final VisitService visitService;

    @Override
    public ResponseEntity<VisitList> get() {
        return new ResponseEntity<>(visitService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(visitService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitList> getByPatientId(UUID patientId) {
        return new ResponseEntity<>(visitService.getByPatientId(patientId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitList> getByDiseaseId(UUID diseaseId) {
        return new ResponseEntity<>(visitService.getByDiseaseId(diseaseId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VisitList> getByCreatedDate(OffsetDateTime createdDate) {
        return new ResponseEntity<>(visitService.getByCreatedDate(createdDate), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Visit visit) {
        visitService.create(visit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Visit visit) {
        visitService.updateById(id, visit);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        visitService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
