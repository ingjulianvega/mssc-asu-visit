package ingjulianvega.ximic.msscasuvisit.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit implements Serializable {

    static final long serialVersionUID = -4592673704938978571L;

    private UUID patientId;
    private UUID companionId;
    private UUID visitTypeId;
    private UUID billingId;
    private String reason;
    private int height;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int weight;
    private int heartRate;
    private float temperature;
    private UUID diseaseId;
    private String observations;

}
