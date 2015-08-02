package com.ee.fb.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.ee.fb.domain.PersonalData;
import com.ee.fb.repository.PersonalDataRepository;
import com.ee.fb.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing PersonalData.
 */
@RestController
@RequestMapping("/api")
public class PersonalDataResource {

    private final Logger log = LoggerFactory.getLogger(PersonalDataResource.class);

    @Inject
    private PersonalDataRepository personalDataRepository;

    /**
     * POST  /personalDatas -> Create a new personalData.
     */
    @RequestMapping(value = "/personalDatas",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> create(@Valid @RequestBody PersonalData personalData) throws URISyntaxException {
        log.debug("REST request to save PersonalData : {}", personalData);
        if (personalData.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new personalData cannot already have an ID").build();
        }
        personalDataRepository.save(personalData);
        return ResponseEntity.created(new URI("/api/personalDatas/" + personalData.getId())).build();
    }

    /**
     * PUT  /personalDatas -> Updates an existing personalData.
     */
    @RequestMapping(value = "/personalDatas",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> update(@Valid @RequestBody PersonalData personalData) throws URISyntaxException {
        log.debug("REST request to update PersonalData : {}", personalData);
        if (personalData.getId() == null) {
            return create(personalData);
        }
        personalDataRepository.save(personalData);
        return ResponseEntity.ok().build();
    }

    /**
     * GET  /personalDatas -> get all the personalDatas.
     */
    @RequestMapping(value = "/personalDatas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<PersonalData>> getAll(@RequestParam(value = "page" , required = false) Integer offset,
                                  @RequestParam(value = "per_page", required = false) Integer limit)
        throws URISyntaxException {
        Page<PersonalData> page = personalDataRepository.findAll(PaginationUtil.generatePageRequest(offset, limit));
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/personalDatas", offset, limit);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /personalDatas/:id -> get the "id" personalData.
     */
    @RequestMapping(value = "/personalDatas/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PersonalData> get(@PathVariable String id) {
        log.debug("REST request to get PersonalData : {}", id);
        return Optional.ofNullable(personalDataRepository.findOne(id))
            .map(personalData -> new ResponseEntity<>(
                personalData,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /personalDatas/:id -> delete the "id" personalData.
     */
    @RequestMapping(value = "/personalDatas/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable String id) {
        log.debug("REST request to delete PersonalData : {}", id);
        personalDataRepository.delete(id);
    }
}
