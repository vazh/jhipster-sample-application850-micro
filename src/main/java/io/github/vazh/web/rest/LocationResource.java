package io.github.vazh.web.rest;

import io.github.vazh.repository.LocationRepository;
import io.github.vazh.service.LocationQueryService;
import io.github.vazh.service.LocationService;
import io.github.vazh.service.criteria.LocationCriteria;
import io.github.vazh.service.dto.LocationDTO;
import io.github.vazh.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link io.github.vazh.domain.Location}.
 */
@RestController
@RequestMapping("/api/locations")
public class LocationResource {

    private final Logger log = LoggerFactory.getLogger(LocationResource.class);

    private static final String ENTITY_NAME = "jhipsterSampleApplicationLocation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LocationService locationService;

    private final LocationRepository locationRepository;

    private final LocationQueryService locationQueryService;

    public LocationResource(
        LocationService locationService,
        LocationRepository locationRepository,
        LocationQueryService locationQueryService
    ) {
        this.locationService = locationService;
        this.locationRepository = locationRepository;
        this.locationQueryService = locationQueryService;
    }

    /**
     * {@code POST  /locations} : Create a new location.
     *
     * @param locationDTO the locationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new locationDTO, or with status {@code 400 (Bad Request)} if the location has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) throws URISyntaxException {
        log.debug("REST request to save Location : {}", locationDTO);
        if (locationDTO.getId() != null) {
            throw new BadRequestAlertException("A new location cannot already have an ID", ENTITY_NAME, "idexists");
        }
        locationDTO = locationService.save(locationDTO);
        return ResponseEntity.created(new URI("/api/locations/" + locationDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, locationDTO.getId().toString()))
            .body(locationDTO);
    }

    /**
     * {@code PUT  /locations/:id} : Updates an existing location.
     *
     * @param id the id of the locationDTO to save.
     * @param locationDTO the locationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated locationDTO,
     * or with status {@code 400 (Bad Request)} if the locationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the locationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody LocationDTO locationDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Location : {}, {}", id, locationDTO);
        if (locationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, locationDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!locationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        locationDTO = locationService.update(locationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, locationDTO.getId().toString()))
            .body(locationDTO);
    }

    /**
     * {@code PATCH  /locations/:id} : Partial updates given fields of an existing location, field will ignore if it is null
     *
     * @param id the id of the locationDTO to save.
     * @param locationDTO the locationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated locationDTO,
     * or with status {@code 400 (Bad Request)} if the locationDTO is not valid,
     * or with status {@code 404 (Not Found)} if the locationDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the locationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<LocationDTO> partialUpdateLocation(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody LocationDTO locationDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Location partially : {}, {}", id, locationDTO);
        if (locationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, locationDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!locationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<LocationDTO> result = locationService.partialUpdate(locationDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, locationDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /locations} : get all the locations.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of locations in body.
     */
    @GetMapping("")
    public ResponseEntity<List<LocationDTO>> getAllLocations(
        LocationCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Locations by criteria: {}", criteria);

        Page<LocationDTO> page = locationQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /locations/count} : count all the locations.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countLocations(LocationCriteria criteria) {
        log.debug("REST request to count Locations by criteria: {}", criteria);
        return ResponseEntity.ok().body(locationQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /locations/:id} : get the "id" location.
     *
     * @param id the id of the locationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the locationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable("id") Long id) {
        log.debug("REST request to get Location : {}", id);
        Optional<LocationDTO> locationDTO = locationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(locationDTO);
    }

    /**
     * {@code DELETE  /locations/:id} : delete the "id" location.
     *
     * @param id the id of the locationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id) {
        log.debug("REST request to delete Location : {}", id);
        locationService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
