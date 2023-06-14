package com.concesionario.continente.repository;

import com.concesionario.continente.entity.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity,Long> {
}
