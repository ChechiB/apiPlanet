package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.PlanetSimpleDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.DTO.StarSimpleDTO;
import com.example.demo.Repository.PlanetRepository;
import com.example.demo.Repository.StarRepository;
import com.example.demo.Service.PlanetService;
import com.example.demo.Service.StarService;
import com.example.exception.StatusException;

public class PlanetTestCase {
	@Mock
	private static PlanetService planetService;
	@Mock
	private static PlanetRepository planetRepository;
	private static PlanetDTO planet1;
	private static StarSimpleDTO star1;
	private static ArrayList<StarSimpleDTO> stars;
	private static ArrayList<PlanetDTO> planetList= new ArrayList<>();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeClass
	public static void init() {
		planetService = mock(PlanetService.class);
		planet1 = new PlanetDTO();
		star1 = new StarSimpleDTO();
		star1.setDensity(13413.0);
		star1.setName("vega");
		planet1.setId(1);		
		planet1.setName("tierra");
		planet1.setSize(353552.0);
		planet1.setStar(star1);
		planetList.add(planet1);
	
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test(expected = AssertionError.class)
	public void getNoPlanetTest() throws StatusException {
		int idPlanet = 7;
		
		when(planetService.getOne(idPlanet)).thenReturn(planet1);

		exception.expect(AssertionError.class);
		planetService.getOne(7);
		
	}
	
	@Test 
	public void getPlanet() throws StatusException {
		int idPlanet = 1;
		
		when(planetService.getOne(idPlanet)).thenReturn(planet1);
		
		PlanetDTO planet = planetService.getOne(1);
		
		assertNotNull(planet);
		assertEquals(1,planet.getId());
	}
	
	@Test
	public void getPlanetsTest() throws StatusException{
		when(planetService.getAll()).thenReturn(planetList);
		
		assertEquals(1, planetService.getAll().size());
	}
	
	@Test
	public void savePlanet() throws StatusException {
		PlanetDTO planetDto = new PlanetDTO();
		planetDto.setName("tierra");
		planetDto.setSize(0.5);
	
		StarSimpleDTO starDto = new StarSimpleDTO();
		starDto.setId(5);	
		planetDto.setStar(starDto);
		
		when(planetService.post(planetDto)).thenReturn(planetDto);
		exception.expect(DataIntegrityViolationException.class);;
		planetService.post(planetDto);
		
	}
	
	@Test(expected =InvalidDataAccessApiUsageException.class )
	public void savePlanetWithourStar() throws StatusException {
		PlanetDTO planetDto = new PlanetDTO();
		planetDto.setName("tierra");
		planetDto.setSize(0.5);
	
		when(planetService.post(planetDto)).thenReturn(planetDto);
		
		exception.expect(AssertionError.class);
		planetService.post(planetDto);
		
	}
	

	
	@Test
	public void deletePlanet() throws StatusException {
		int id = 5;
		assertEquals(true,planetService.delete(id));
	}
	

	@Test(expected = AssertionError.class)
	public void updateStar() {
		int id = 4;
		
		try {
			exception.expect(AssertionError.class);
			planetService.put(planet1, id);
		} catch (StatusException e) {
			e.printStackTrace();
		}
		
	}

}
