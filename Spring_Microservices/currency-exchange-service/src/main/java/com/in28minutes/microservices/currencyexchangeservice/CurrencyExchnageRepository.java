package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchnageRepository extends JpaRepository<CurrencyExchange, Long>{
     CurrencyExchange findByFromAndTo(String from, String to);
}
