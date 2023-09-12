package com.nodemngmt.repository
import com.nodemngmt.entity.ComplianceEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
@Repository
interface ComplianceRepository: CrudRepository<ComplianceEntity, String> {

}