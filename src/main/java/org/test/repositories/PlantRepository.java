package org.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.models.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

	
}
