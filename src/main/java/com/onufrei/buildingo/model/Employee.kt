package com.onufrei.buildingo.model

import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Document
data class Employee(
        @ApiModelProperty(notes="The id of the employee in UUID format.")
        @Id
        var id: String = UUID.randomUUID().toString(),
        @ApiModelProperty(notes="The name of the employee.")
        var name: String,
        @ApiModelProperty(notes="The surname of the employee.")
        var surname: String,
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        @ApiModelProperty(notes="The date of birth of the employee.")
        var dateOfBirth: LocalDate?,
        @ApiModelProperty(notes="The employee's brigade.")
        var brigade: Brigade?,
        @ApiModelProperty(notes="The salary of the employee.")
        var salary: Int = 0,
        @ApiModelProperty(notes="The phone number of the employee.")
        var phoneNumber: String?,
        @ApiModelProperty(notes="The e-mail of the employee.")
        var email: String,
        @ApiModelProperty(notes="The date when employee was hired.")
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        var hiredDate: LocalDate?,
        @ApiModelProperty(notes="The date when employee was lastly modified.")
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        var firedDate: LocalDate?,
        @ApiModelProperty(notes="Shows if employee can do their work.")
        var active: Boolean,
        @ApiModelProperty(notes="The specification of the employee.")
        var specification: EmployeeSpecification?,
        @ApiModelProperty(notes="The date and time when object was created.")
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @ApiModelProperty(notes="The date and time when object was lastly modified.")
        var modifiedAt: LocalDateTime = LocalDateTime.now()
)