package br.com.horys.resources.requests

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

class CreateBetRequest(
    @field:Positive val number: Int = 0,
    @field:NotBlank val type: String = "",
    @field:Positive val supplierId: Long = 0,
    @field:Positive val reservation: Int = 0,
    @field:NotBlank val date: String = ""
)