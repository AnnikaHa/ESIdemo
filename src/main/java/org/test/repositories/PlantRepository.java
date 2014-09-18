package org.test.repositories;


import java.util.Calendar;
import java.util.Date;
import java.util.List;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.test.models.Plant;



@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
	
	
	List<Plant> findByNameLike(String name);

	@Query("select p from Plant p " +
	           "where LOWER(p.name) like LOWER(:name) and p.price between :minimum and :maximum")
	    List<Plant> finderMethod(@Param("name") String name, 
	                               @Param("minimum") Float minimum,
	                               @Param("maximum") Float maximum);

	
    @Query("select po from PurchaseOrder po right outer join po.plant p " +
            "where date(:date2) < po.startDate or date(:date1) > po.endDate or po.id is null ")	
	List<Plant> finderMethod(@Param("date1") String date1, @Param("date2") String date2 );
    
    
    
    
    
	/*
    @Query("select p from Plant p left outer join PurchaseOrder po on p.id=po.id " +
            "where (:date1 < po.startDate and :date2 < po.startDate) or (po.endDate < :date1 and po.endDate < :date2) or po.id is null ")	
	List<Plant> finderMethod(@Param("date1") String date1, @Param("date2") String date2 );
    */
	/*@Query("select p from Plant p left outer join PurchaseOrder o on " +
            "where (:date1 < p.startDate and :date2 < p.startDate) or (p.endDate < :date1 and p.endDate < :date2) ")	
	List<Plant> finderMethod(@Param("date1") Calendar date1, @Param("date2") Calendar date2 );
	*/
}
