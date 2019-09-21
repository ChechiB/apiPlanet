package com.example.demo;

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
import com.example.demo.DTO.PlanetSimpleDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Repository.StarRepository;
import com.example.demo.Service.StarService;
import com.example.exception.StatusException;

public class StarTestCase {
	@Mock
	private static StarService starService;
	@Mock
	private static StarRepository starRepository;
	private static StarDTO star1;
	private static StarDTO star2;
	private static PlanetSimpleDTO planet1;
	private static ArrayList<PlanetSimpleDTO> planets;
	private static ArrayList<StarDTO> starList= new ArrayList<>();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeClass
	public static void init() {
		starService = mock(StarService.class);
		star1 = new StarDTO();
		planet1 = new PlanetSimpleDTO();
		planets = new ArrayList<>();
		star1.setId(2);
		star1.setDensity(13413.0);
		star1.setName("vega");
		planet1.setId(1);
		planet1.setName("tierra");
		planet1.setSize(353552.0);
		planets.add(planet1);
		star1.setPlanets(planets);
		
		star2 = new StarDTO();
		star1.setId(2);
		star1.setDensity(13413.0);
		star1.setName("vega");
	
		starList.add(star1);
		starList.add(star2);
	
	}
	
	@Test
	public void getStarTest() throws StatusException {
		int idStar = 2;
		
		when(starService.getOne(idStar)).thenReturn(star1);
		
		StarDTO star = starService.getOne(2);
		
		assertNotNull(star);
		assertEquals(2,star.getId());
		assertTrue(star1.getPlanets().size() == star.getPlanets().size());
	}
	
	@Test
	public void getStarsTest() throws StatusException{
		when(starService.getAll()).thenReturn(starList);
		
		assertEquals(2, starService.getAll().size());
	}
	
	@Test
	public void saveStar() throws StatusException {
		StarDTO starDto = new StarDTO();
		starDto.setName("star5");
		starDto.setDensity(342.0);
		
		when(starService.post(starDto)).thenReturn(starDto);
		
		assertEquals(starDto, starService.post(starDto));
		
	}
	
	@Test
	public void deleteStar() throws StatusException {
		int id = 9;
		assertEquals(false,starService.delete(id));
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test(expected = AssertionError.class)
	public void updateStar() {
		int id = 4;
		
		try {
			exception.expect(AssertionError.class);
			starService.put(star1, id);
		} catch (StatusException e) {
			e.printStackTrace();
		}
		
	}
}
