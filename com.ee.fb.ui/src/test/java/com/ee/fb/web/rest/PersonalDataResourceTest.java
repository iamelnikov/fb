package com.ee.fb.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ee.fb.Application;
import com.ee.fb.domain.PersonalData;
import com.ee.fb.repository.PersonalDataRepository;


/**
 * Test class for the PersonalDataResource REST controller.
 *
 * @see PersonalDataResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class PersonalDataResourceTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private static final String DEFAULT_LAST_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_LAST_NAME = "UPDATED_TEXT";
    private static final String DEFAULT_FIRST_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_FIRST_NAME = "UPDATED_TEXT";
    private static final String DEFAULT_MIDDLE_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_MIDDLE_NAME = "UPDATED_TEXT";

    private static final Date DEFAULT_BIRTH_DATE = new Date();
    private static final Date UPDATED_BIRTH_DATE = new Date();
    private static final String DEFAULT_BIRTH_DATE_STR = dateTimeFormatter.print(DEFAULT_BIRTH_DATE.getTime());
    private static final String DEFAULT_BIRTH_PLACE = "SAMPLE_TEXT";
    private static final String UPDATED_BIRTH_PLACE = "UPDATED_TEXT";

    @Inject
    private PersonalDataRepository personalDataRepository;

    private MockMvc restPersonalDataMockMvc;

    private PersonalData personalData;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        PersonalDataResource personalDataResource = new PersonalDataResource();
        ReflectionTestUtils.setField(personalDataResource, "personalDataRepository", personalDataRepository);
        this.restPersonalDataMockMvc = MockMvcBuilders.standaloneSetup(personalDataResource).build();
    }

    @Before
    public void initTest() {
        personalDataRepository.deleteAll();
        personalData = new PersonalData();
        personalData.setLastName(DEFAULT_LAST_NAME);
        personalData.setFirstName(DEFAULT_FIRST_NAME);
        personalData.setMiddleName(DEFAULT_MIDDLE_NAME);
        personalData.setBirthDate(DEFAULT_BIRTH_DATE);
        personalData.setBirthPlace(DEFAULT_BIRTH_PLACE);
    }

    @Test
    public void createPersonalData() throws Exception {
        int databaseSizeBeforeCreate = personalDataRepository.findAll().size();

        // Create the PersonalData
        restPersonalDataMockMvc.perform(post("/api/personalDatas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(personalData)))
                .andExpect(status().isCreated());

        // Validate the PersonalData in the database
        List<PersonalData> personalDatas = personalDataRepository.findAll();
        assertThat(personalDatas).hasSize(databaseSizeBeforeCreate + 1);
        PersonalData testPersonalData = personalDatas.get(personalDatas.size() - 1);
        assertThat(testPersonalData.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testPersonalData.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testPersonalData.getMiddleName()).isEqualTo(DEFAULT_MIDDLE_NAME);
        assertThat(testPersonalData.getBirthDate().equals(DEFAULT_BIRTH_DATE));
        assertThat(testPersonalData.getBirthPlace()).isEqualTo(DEFAULT_BIRTH_PLACE);
    }

    @Test
    public void getAllPersonalDatas() throws Exception {
        // Initialize the database
        personalDataRepository.save(personalData);

        // Get all the personalDatas
        restPersonalDataMockMvc.perform(get("/api/personalDatas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(hasItem(personalData.getId())))
                .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME.toString())))
                .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME.toString())))
                .andExpect(jsonPath("$.[*].middleName").value(hasItem(DEFAULT_MIDDLE_NAME.toString())))
                .andExpect(jsonPath("$.[*].birthDate").value(hasItem(DEFAULT_BIRTH_DATE_STR)))
                .andExpect(jsonPath("$.[*].birthPlace").value(hasItem(DEFAULT_BIRTH_PLACE.toString())));
    }

    @Test
    public void getPersonalData() throws Exception {
        // Initialize the database
        personalDataRepository.save(personalData);

        // Get the personalData
        restPersonalDataMockMvc.perform(get("/api/personalDatas/{id}", personalData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(personalData.getId()))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME.toString()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME.toString()))
            .andExpect(jsonPath("$.middleName").value(DEFAULT_MIDDLE_NAME.toString()))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE_STR))
            .andExpect(jsonPath("$.birthPlace").value(DEFAULT_BIRTH_PLACE.toString()));
    }

    @Test
    public void getNonExistingPersonalData() throws Exception {
        // Get the personalData
        restPersonalDataMockMvc.perform(get("/api/personalDatas/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updatePersonalData() throws Exception {
        // Initialize the database
        personalDataRepository.save(personalData);

		int databaseSizeBeforeUpdate = personalDataRepository.findAll().size();

        // Update the personalData
        personalData.setLastName(UPDATED_LAST_NAME);
        personalData.setFirstName(UPDATED_FIRST_NAME);
        personalData.setMiddleName(UPDATED_MIDDLE_NAME);
        personalData.setBirthDate(UPDATED_BIRTH_DATE);
        personalData.setBirthPlace(UPDATED_BIRTH_PLACE);
        restPersonalDataMockMvc.perform(put("/api/personalDatas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(personalData)))
                .andExpect(status().isOk());

        // Validate the PersonalData in the database
        List<PersonalData> personalDatas = personalDataRepository.findAll();
        assertThat(personalDatas).hasSize(databaseSizeBeforeUpdate);
        PersonalData testPersonalData = personalDatas.get(personalDatas.size() - 1);
        assertThat(testPersonalData.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testPersonalData.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testPersonalData.getMiddleName()).isEqualTo(UPDATED_MIDDLE_NAME);
        assertThat(testPersonalData.getBirthDate().equals(UPDATED_BIRTH_DATE));
        assertThat(testPersonalData.getBirthPlace()).isEqualTo(UPDATED_BIRTH_PLACE);
    }

    @Test
    public void deletePersonalData() throws Exception {
        // Initialize the database
        personalDataRepository.save(personalData);

		int databaseSizeBeforeDelete = personalDataRepository.findAll().size();

        // Get the personalData
        restPersonalDataMockMvc.perform(delete("/api/personalDatas/{id}", personalData.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<PersonalData> personalDatas = personalDataRepository.findAll();
        assertThat(personalDatas).hasSize(databaseSizeBeforeDelete - 1);
    }
}
