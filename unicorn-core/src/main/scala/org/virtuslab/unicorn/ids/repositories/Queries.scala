package org.virtuslab.unicorn.ids.repositories

import org.virtuslab.unicorn.ids._
import scala.slick.lifted.Shape._
import scala.slick.driver.JdbcDriver

trait Queries extends Identifiers with Tables {
  self: JdbcDriver =>

  import profile.simple._


  /**
   * Base class for all queries with an [[org.virtuslab.unicorn.ids.Identifiers.BaseId]].
   *
   * @tparam I type of id
   * @tparam A type of element that is queried
   * @author Jerzy Müller
   */
  private[repositories] trait BaseIdQueries[I <: BaseId, A <: WithId[I], T <: IdTable[I, A]] {

    /** @return query to operate on */
    protected def query: TableQuery[T]

    /** @return type mapper for I, required for querying */
    protected implicit def mapping: BaseColumnType[I]

    val byIdQuery = Compiled(byIdFunc _)

    /** Query all ids. */
    protected lazy val allIdsQuery = query.map(_.id)

    /** Query element by id, method version. */
    protected def byIdFunc(id: Column[I]) = query.filter(_.id === id)

    /** Query by multiple ids. */
    protected def byIdsQuery(ids: Seq[I]) = query.filter(_.id inSet ids)
  }

}