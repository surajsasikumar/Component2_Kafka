package com.nodemngmt.controller

import com.nodemngmt.entity.ComplianceEntity
import com.nodemngmt.service.ComplianceService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Put

@Controller("/component2")
class ComplianceController(private val complianceService:ComplianceService) {
    @Put("/updateCompliance")
    fun updateCompliance(complianceEntity: ComplianceEntity):ComplianceEntity{
        return complianceService.updateCompliance(complianceEntity)
    }
}