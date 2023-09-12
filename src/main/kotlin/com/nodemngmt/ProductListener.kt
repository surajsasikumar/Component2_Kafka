package com.nodemngmt

import com.nodemngmt.controller.ComplianceController
import com.nodemngmt.entity.ComplianceEntity
import com.nodemngmt.entity.Item
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ProductListener(private val complianceController: ComplianceController) {
    @Topic("component1")
    fun receive(@KafkaKey brand:String,name:Item) {
        val tcin = name.tcin
        val isFlammable = name.compliance.isFlammable
        val isHazmatPublishable = name.compliance.isHazmatPublishable
        val lithiumClassified = name.compliance.lithiumClassified

        val complianceEntity= ComplianceEntity(tcin,isFlammable,isHazmatPublishable,lithiumClassified)

        complianceController.updateCompliance(complianceEntity)
        println("Received response - "+ name.compliance)
    }
}