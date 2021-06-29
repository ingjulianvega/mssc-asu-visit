package ingjulianvega.ximic.msscasuvisit.services;

import ingjulianvega.ximic.msscasuvisit.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuvisit.domain.VisitEntity;
import ingjulianvega.ximic.msscasuvisit.domain.repositories.VisitRepository;
import ingjulianvega.ximic.msscasuvisit.exception.VisitException;
import ingjulianvega.ximic.msscasuvisit.web.Mappers.DateMapper;
import ingjulianvega.ximic.msscasuvisit.web.Mappers.VisitMapper;
import ingjulianvega.ximic.msscasuvisit.web.model.Visit;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitDto;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final DateMapper dateMapper;


    @Cacheable(cacheNames = "visitListCache")
    @Override
    public VisitList get() {
        log.debug("get()...");
        return VisitList
                .builder()
                .visitDtoList(visitMapper.visitEntityListToVisitDtoList(visitRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "visitCache")
    @Override
    public VisitDto getById(UUID id) {
        log.debug("getById()...");
        return visitMapper.visitEntityToVisitDto(
                visitRepository.findById(id)
                        .orElseThrow(() -> new VisitException(ErrorCodeMessages.VISIT_NOT_FOUND, "")));
    }

    @Override
    public VisitList getByPatientId(UUID  patientId) {
        log.debug("findByPatientId()...");
        return VisitList
                .builder()
                .visitDtoList(visitMapper.visitEntityListToVisitDtoList(visitRepository.findByPatientId(patientId)))
                .build();
    }

    @Override
    public VisitList getByDiseaseId(UUID diseaseId) {
        log.debug("getByDiseaseId()...");
        return VisitList
                .builder()
                .visitDtoList(visitMapper.visitEntityListToVisitDtoList(visitRepository.findByDiseaseId(diseaseId)))
                .build();
    }

    @Override
    public VisitList getByCreatedDate(OffsetDateTime createdDate) {
        log.debug("findByCreatedDate()...");
        OffsetDateTime from = OffsetDateTime.of(createdDate.getYear(), createdDate.getMonthValue(), createdDate.getDayOfMonth(), 0, 0, 0, 0,createdDate.getOffset());
        OffsetDateTime to = OffsetDateTime.of(createdDate.getYear(), createdDate.getMonthValue(), createdDate.getDayOfMonth(), 23, 59, 59, 0,createdDate.getOffset());

        return VisitList
                .builder()
                .visitDtoList(visitMapper.visitEntityListToVisitDtoList(
                        visitRepository.findByCreatedDateBetween(
                                dateMapper.asTimestamp(from),
                                dateMapper.asTimestamp(to))))
                .build();
    }

    @Override
    public void create(Visit visit) {
        log.debug("create()...");
        visitMapper.visitEntityToVisitDto(
                visitRepository.save(
                        visitMapper.visitDtoToVisitEntity(
                                VisitDto
                                        .builder()
                                        .patientId(visit.getPatientId())
                                        .reason(visit.getReason())
                                        .height(visit.getHeight())
                                        .systolicBloodPressure(visit.getSystolicBloodPressure())
                                        .diastolicBloodPressure(visit.getDiastolicBloodPressure())
                                        .weight(visit.getWeight())
                                        .heartRate(visit.getHeartRate())
                                        .temperature(visit.getTemperature())
                                        .diseaseId(visit.getDiseaseId())
                                        .observations(visit.getObservations())
                                        .companionId(visit.getCompanionId())
                                        .visitTypeId(visit.getVisitTypeId())
                                        .billingId(visit.getBillingId())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Visit visit) {
        log.debug("updateById...");
        VisitEntity visitEntity = visitRepository.findById(id)
                .orElseThrow(() -> new VisitException(ErrorCodeMessages.VISIT_NOT_FOUND, ""));

        visitEntity.setPatientId(visit.getPatientId());
        visitEntity.setReason(visit.getReason());
        visitEntity.setHeight(visit.getHeight());
        visitEntity.setSystolicBloodPressure(visit.getSystolicBloodPressure());
        visitEntity.setDiastolicBloodPressure(visit.getDiastolicBloodPressure());
        visitEntity.setWeight(visit.getWeight());
        visitEntity.setHeartRate(visit.getHeartRate());
        visitEntity.setTemperature(visit.getTemperature());
        visitEntity.setDiseaseId(visit.getDiseaseId());
        visitEntity.setObservations(visit.getObservations());
        visitEntity.setCompanionId(visit.getCompanionId());
        visitEntity.setVisitTypeId(visit.getVisitTypeId());
        visitEntity.setBillingId(visit.getBillingId());

        visitRepository.save(visitEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        visitRepository.deleteById(id);
    }
}
