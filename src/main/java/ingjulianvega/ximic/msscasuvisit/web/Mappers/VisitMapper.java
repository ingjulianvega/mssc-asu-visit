package ingjulianvega.ximic.msscasuvisit.web.Mappers;


import ingjulianvega.ximic.msscasuvisit.domain.VisitEntity;
import ingjulianvega.ximic.msscasuvisit.web.model.VisitDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface VisitMapper {
    VisitDto visitEntityToVisitDto(VisitEntity visitEntity);

    VisitEntity visitDtoToVisitEntity(VisitDto visitDto);

    ArrayList<VisitDto> visitEntityListToVisitDtoList(List<VisitEntity> visitEntityList);
}