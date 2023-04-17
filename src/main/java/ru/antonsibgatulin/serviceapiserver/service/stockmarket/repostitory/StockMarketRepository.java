package ru.antonsibgatulin.serviceapiserver.service.stockmarket.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.antonsibgatulin.serviceapiserver.service.stockmarket.StockMarket;

import java.util.List;

public interface StockMarketRepository extends JpaRepository<StockMarket,Long> {

    @Query("from StockMarket s WHERE s.timeCreate > :time and s.userId = :userId")
    List<StockMarket> findAllWhereTimeCreateMoreThemNumber(@Param("time") Long time,@Param("userId") Long userId);

}
