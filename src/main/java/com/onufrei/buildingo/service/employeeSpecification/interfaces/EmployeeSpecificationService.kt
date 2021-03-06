package com.onufrei.buildingo.service.employeeSpecification.interfaces

import com.onufrei.buildingo.model.EmployeeSpecification
import com.onufrei.buildingo.service.CrudGenericService

interface EmployeeSpecificationService : CrudGenericService<EmployeeSpecification> {
    fun getListOfSpecificationNames() : List<Pair<String, String>>
}