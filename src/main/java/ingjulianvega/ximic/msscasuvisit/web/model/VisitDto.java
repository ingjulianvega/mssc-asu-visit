package ingjulianvega.ximic.msscasuvisit.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitDto implements Serializable {

    static final long serialVersionUID = -9064696585853523327L;

    private UUID id;
    private UUID patientId;
    private UUID companionId;
    private UUID visitTypeId;
    private UUID billingId;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private float weight;
    private int heartRate;
    private float temperature;
    private UUID diseaseId;
    private String observations;
    private OffsetDateTime createdDate;

}