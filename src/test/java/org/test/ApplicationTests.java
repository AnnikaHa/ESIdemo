package org.test;




import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.repositories.PlantRepository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, SimpleDbConfig.class})
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class ApplicationTests {
    @Autowired
    PlantRepository plantRepo;

    @Test
    @DatabaseSetup("dataset.xml")
    public void countAllPlants() {
        assertEquals(14, plantRepo.count());
    }

    @Test
    @DatabaseSetup("dataset.xml")
    public void countExcavators() {
        assertEquals(6, plantRepo.findByNameLike("Excavator").size());
    }
    
    @Test
    @DatabaseSetup("dataset.xml")
    public void countLikeNameAndPriceRange() {
        assertEquals(4, plantRepo.finderMethod("Excavator", 200.00f, 400.00f).size());
    }
    
    @Test
    @DatabaseSetup("dataset.xml")
    public void countLikeNameAndFree() {
    	/*
    	Calendar date = Calendar.getInstance();
    	date.set(2014, 9, 22);
//    	date.set(Calendar.HOUR_OF_DAY, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//    	date.set(2014, 9, 18);
//    	Date date1 = date.getTime();
//    	date.set(2014, 9, 24);
//    	Date date2 = date.getTime();
    	
    	Calendar date2 = Calendar.getInstance();
    	date2.set(2014, 9, 26);
    	System.out.println("------------------------------------------------------------------");
    	System.out.println(plantRepo.finderMethod(date,date2).size());
    	assertEquals(13, plantRepo.finderMethod( date,date2).size());
    	
    	*/
    	
    	System.out.println("------------------------------------------------------------------");
    	System.out.println(plantRepo.finderMethod("2014-09-14","2014-09-20").size());
        assertEquals(12, plantRepo.finderMethod( "2014-09-14","2014-09-20").size());
    }
    
}