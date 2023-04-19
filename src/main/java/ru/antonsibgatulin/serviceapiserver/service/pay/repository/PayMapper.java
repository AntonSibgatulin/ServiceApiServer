package ru.antonsibgatulin.serviceapiserver.service.pay.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.antonsibgatulin.serviceapiserver.controllers.api.pay.request.PayRequest;
import ru.antonsibgatulin.serviceapiserver.service.pay.Pay;
@Mapper(componentModel = "spring")
public interface PayMapper {
    @Mapping(target = "type",source = "type")
    @Mapping(target = "data",source = "data")
    Pay fromPayRequesttoPay(PayRequest payRequest);
}
