package ru.antonsibgatulin.serviceapiserver.controllers.api.stockmarket.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.StockMarket;

@Mapper(componentModel = "spring")
public interface StockMarketRequestModelMapper {
    @Mapping(target = "name",source = "name")
    @Mapping(target = "description",source = "description")
    @Mapping(target = "price",source = "price")
    @Mapping(target = "maxprice",source = "maxprice")
    @Mapping(target = "typeWall",source = "typeWall")
    @Mapping(target = "timeCreate",source = "timeCreate")
    @Mapping(target = "time",source = "time")
    StockMarket FromRequestToStockMarket(StockMarketRequestModel stockMarketRequestModel);
}
