package com.alondrasystems.my_first_api.repository;

import com.alondrasystems.my_first_api.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}