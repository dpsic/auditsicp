package com.example.projet.feign;

import com.example.projet.modals.Organe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ORGANE-SERVICE")
public interface OrganeRestClient {
    @GetMapping(value="/api/perso/organes/{id}")
    Organe getOrganeById(@PathVariable Long id);
}
