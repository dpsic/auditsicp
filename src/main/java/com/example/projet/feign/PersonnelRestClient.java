package com.example.projet.feign;

import com.example.projet.modals.Organe;
import com.example.projet.modals.Personnel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PERSONNEL-SERVICE")
public interface PersonnelRestClient {
    @GetMapping(value="/api/perso/{id}")
    Personnel getPersoById(@PathVariable Long id);
    @GetMapping(value="/api/perso/organes/{id}")
    Organe getOrganeById(@PathVariable Long id);
}
