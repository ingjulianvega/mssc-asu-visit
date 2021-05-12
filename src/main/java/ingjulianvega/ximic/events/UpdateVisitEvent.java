package ingjulianvega.ximic.events;

import ingjulianvega.ximic.msscasuvisit.web.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateVisitEvent {

    private Visit visit;
}
