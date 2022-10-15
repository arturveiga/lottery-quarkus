package br.com.horys.models

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "bets")
data class Bet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val number: Int,
    @Enumerated(EnumType.STRING)
    val type: TypeBet,
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    val supplier: Supplier,
    val reservation: Int,
    val availableReservation: Int,
    val date: LocalDate,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    enum class TypeBet {
        LOTOMANIA, LOTOFACIL
    }
}