package ingjulianvega.ximic.msscasuvisit.web.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private String code;
    private String description;
}
