package ingjulianvega.ximic.msscasuvisit.listener;

import ingjulianvega.ximic.events.UpdateVisitEvent;
import ingjulianvega.ximic.msscasuvisit.configuration.JmsConfig;
import ingjulianvega.ximic.msscasuvisit.services.VisitService;
import ingjulianvega.ximic.msscasuvisit.web.Mappers.VisitMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateVisitListener {

    private final VisitService visitService;
    private final VisitMapper visitMapper;

    @JmsListener(destination = JmsConfig.UPDATE_VISIT_QUEUE)
    public void listen(UpdateVisitEvent updateVisitEvent){
        log.debug("Got UpdateVisitEvent " + updateVisitEvent.toString());
        visitService.create(visitMapper.updateVisitEventToVisit(updateVisitEvent));
    }
}
