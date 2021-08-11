package com.example.projet.services;

import com.example.projet.entities.Aspect;

public interface AspectServices {
    Aspect save(Aspect eval);

    Aspect findById(Long id);
    
}
