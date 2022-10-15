package br.com.horys.repositories

import br.com.horys.models.Bet
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BetRepository : PanacheRepository<Bet> {
}