package io.github.vazh.service;

import io.github.vazh.domain.*; // for static metamodels
import io.github.vazh.domain.Department;
import io.github.vazh.repository.DepartmentRepository;
import io.github.vazh.service.criteria.DepartmentCriteria;
import io.github.vazh.service.dto.DepartmentDTO;
import io.github.vazh.service.mapper.DepartmentMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Department} entities in the database.
 * The main input is a {@link DepartmentCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link DepartmentDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class DepartmentQueryService extends QueryService<Department> {

    private final Logger log = LoggerFactory.getLogger(DepartmentQueryService.class);

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentQueryService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    /**
     * Return a {@link Page} of {@link DepartmentDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findByCriteria(DepartmentCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Department> specification = createSpecification(criteria);
        return departmentRepository.findAll(specification, page).map(departmentMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(DepartmentCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Department> specification = createSpecification(criteria);
        return departmentRepository.count(specification);
    }

    /**
     * Function to convert {@link DepartmentCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Department> createSpecification(DepartmentCriteria criteria) {
        Specification<Department> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Department_.id));
            }
            if (criteria.getDepartmentName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDepartmentName(), Department_.departmentName));
            }
            if (criteria.getLocationId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getLocationId(), root -> root.join(Department_.location, JoinType.LEFT).get(Location_.id))
                );
            }
            if (criteria.getEmployeeId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getEmployeeId(), root -> root.join(Department_.employees, JoinType.LEFT).get(Employee_.id))
                );
            }
            if (criteria.getJobHistoryId() != null) {
                specification = specification.and(
                    buildSpecification(
                        criteria.getJobHistoryId(),
                        root -> root.join(Department_.jobHistory, JoinType.LEFT).get(JobHistory_.id)
                    )
                );
            }
        }
        return specification;
    }
}
