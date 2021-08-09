package ingjulianvega.ximic.msscasuvisit.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit {

    @NotNull
    private UUID patientId;
    private UUID companionId;
    @NotNull
    private UUID visitTypeId;
    @NotNull
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

}
