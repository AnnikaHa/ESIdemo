package org.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.models.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
