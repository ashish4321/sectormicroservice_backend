package com.wellsfargo.stockmarket.stockdataretrieval.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wellsfargo.stockmarket.stockdataretrieval.model.Company;
import com.wellsfargo.stockmarket.stockdataretrieval.model.Sector;
import com.wellsfargo.stockmarket.stockdataretrieval.service.SectorService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SectorService sectorService;
	
	@Test
	@DisplayName("Test all sectors found success scenario - GET /sectors")
	public void testAllSectorsFoundSuccess() throws Exception{
		Sector firstSector = new Sector(1L,"first sector","this is first sector");
		Sector SecondSector = new Sector(2L,"second sector","this is second sector");
		
		List<Sector> sectors = new ArrayList<>();
		sectors.add(firstSector);
		sectors.add(SecondSector);
		
		doReturn(sectors).when(sectorService).getAllSectors();

		mockMvc.perform(MockMvcRequestBuilders.get("/sectors"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$[0].sectorName",is("first sector")))
		.andExpect(jsonPath("$[1].sectorName",is("second sector")));
	}
	

	
	@Test
	@DisplayName("Test Sector Found Success Scenario - GET /sectors/1")
	public void testGetSectorByIdSuccess() throws Exception{
		
		Sector mockSector = new Sector(1L,"mock","this is mock sector");
		doReturn(mockSector).when(sectorService).getSector(mockSector.getSectorId());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/sectors/{sectorid}", 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.sectorId",is(1)))
		.andExpect(jsonPath("$.sectorName",is("mock")))
		.andExpect(jsonPath("$.brief",is("this is mock sector")));
	}
	

	
	@Test
	@DisplayName("Test all companies in a sector found success scenario - GET /sectors/1/companies")
	public void testCompaniesInSectorSuccess() throws Exception{
		
		Sector mockSector = new Sector(1L,"mock","this is mock sector");
		Company mockCompany1 = new Company(1000,"mock company 1", "mock",4001);
		Company mockCompany2 = new Company(1001,"mock company 2", "mock",4002);
		List<Company> mockCompanies = new ArrayList<>();
		mockCompanies.add(mockCompany1);
		mockCompanies.add(mockCompany2);
		
		doReturn(mockCompanies).when(sectorService).getCompany(mockSector.getSectorId());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/sectors/{sectorid}/companies", 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$[0].companyName",is("mock company 1")))
		.andExpect(jsonPath("$[1].companyName",is("mock company 2")));
	}

	
	@Test
	@DisplayName("Test delete sector found success scenario - DELETE /sectors")
	public void testDeleteSectorSuccess() throws Exception{
		
		Sector mockSector = new Sector(1L,"mock","this is mock sector");
		
		doReturn("sector deleted").when(sectorService).deleteSector(mockSector.getSectorId());
		
		String result = mockMvc.perform(MockMvcRequestBuilders.delete("/sectors/{sectorid}", 1))
						.andReturn()
						.getResponse()
						.getContentAsString();
		
		Assertions.assertEquals("sector deleted", result);
		
	}
	
}
