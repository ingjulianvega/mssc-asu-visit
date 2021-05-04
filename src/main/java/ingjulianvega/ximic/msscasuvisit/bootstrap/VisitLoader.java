package ingjulianvega.ximic.msscasuvisit.bootstrap;

import ingjulianvega.ximic.msscasuvisit.domain.VisitEntity;
import ingjulianvega.ximic.msscasuvisit.domain.repositories.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class VisitLoader implements CommandLineRunner {

    private final VisitRepository visitRepository;

    @Override
    public void run(String... args) throws Exception {
        if (visitRepository.count() == 0) {
            loadVisitObjects();
        }
    }

    private void loadVisitObjects() {
        visitRepository.saveAll(Arrays.asList(
                VisitEntity.builder()
                        .patientId(UUID.randomUUID())
                        .reason("reason 1")
                        .height(168)
                        .systolicBloodPressure(60)
                        .diastolicBloodPressure(120)
                        .weight(80)
                        .heartRate(78)
                        .temperature(35.6f)
                        .diseaseId(UUID.randomUUID())
                        .observations("Observations")
                        .companionId(UUID.randomUUID())
                        .visitTypeId(UUID.randomUUID())
                        .billingId(UUID.randomUUID())
                        .build(),
                VisitEntity.builder()
                        .patientId(UUID.randomUUID())
                        .reason("reason 2")
                        .height(162)
                        .systolicBloodPressure(62)
                        .diastolicBloodPressure(122)
                        .weight(82)
                        .heartRate(72)
                        .temperature(35.2f)
                        .diseaseId(UUID.randomUUID())
                        .observations("Observations 2")
                        .companionId(UUID.randomUUID())
                        .visitTypeId(UUID.randomUUID())
                        .billingId(UUID.randomUUID())
                        .build(),
                VisitEntity.builder()
                        .patientId(UUID.randomUUID())
                        .reason("reason 3")
                        .height(163)
                        .systolicBloodPressure(63)
                        .diastolicBloodPressure(123)
                        .weight(83)
                        .heartRate(73)
                        .temperature(35.3f)
                        .diseaseId(UUID.randomUUID())
                        .observations("Observations 3")
                        .companionId(UUID.randomUUID())
                        .visitTypeId(UUID.randomUUID())
                        .billingId(UUID.randomUUID())
                        .build()

        ));
    }
}