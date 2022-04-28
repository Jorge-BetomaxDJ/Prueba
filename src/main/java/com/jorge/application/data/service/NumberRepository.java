package com.jorge.application.data.service;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.application.data.entity.Telefono;

public interface NumberRepository extends JpaRepository<Telefono, UUID> {

}