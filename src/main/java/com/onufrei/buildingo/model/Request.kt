package com.onufrei.buildingo.model

import io.swagger.annotations.ApiModelProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Document
data class Request(
        @ApiModelProperty(notes="The id of the request in UUID format.")
        @Id
        var id: String = UUID.randomUUID().toString(),
        @ApiModelProperty(notes="The title of the request.")
        var title: String,
        @ApiModelProperty(notes="The description of the request.")
        var description: String?,
        @ApiModelProperty(notes="The type of the request.")
        var type: RequestType?,
        @ApiModelProperty(notes="Indicates if request was implemented.")
        var satisfied: Boolean,
        @ApiModelProperty(notes="The building for which the request was called.")
        var building: Building?,
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        @ApiModelProperty(notes="The date, when request was raised.")
        var date: LocalDate?,
        @ApiModelProperty(notes="The brigade that called the request.")
        var brigadeThatAsked: Brigade?,
        @ApiModelProperty(notes="The construction management that gets the request.")
        var constructionManagement: ConstructionManagement?,
        @ApiModelProperty(notes="The date and time when object was created.")
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @ApiModelProperty(notes="The date and time when object was lastly modified.")
        var modifiedAt: LocalDateTime = LocalDateTime.now()
)