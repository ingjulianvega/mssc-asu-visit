package ingjulianvega.ximic.msscasuvisit.events;

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
public class UpdateVisitEvent implements Serializable {
    static final long serialVersionUID = -125380846123986579L;

    private Visit visit;

}
