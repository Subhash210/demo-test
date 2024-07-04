/**
 * 
 */
package com.admin.mapper;

import org.mapstruct.Mapper;

import com.admin.entity.EmployeeEntity;
import com.admin.request.EmployeeRequest;
import com.admin.response.EmployeeResponse;

/**
 * Mapper interface for converting between Employee entities and DTOs.
 * 
 * <p>This interface uses MapStruct for mapping between {@link EmployeeEntity},
 * {@link EmployeeRequest}, and {@link EmployeeResponse}.</p>
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    /**
     * Maps an {@link EmployeeRequest} to an {@link EmployeeEntity}.
     *
     * @param employeeRequest the employee request DTO
     * @return the mapped employee entity
     */
    EmployeeEntity mapFrom(EmployeeRequest employeeRequest);

    /**
     * Maps an {@link EmployeeEntity} to an {@link EmployeeResponse}.
     *
     * @param employeeEntity the employee entity
     * @return the mapped employee response DTO
     */
    EmployeeResponse mapResponse(EmployeeEntity employeeEntity);

}