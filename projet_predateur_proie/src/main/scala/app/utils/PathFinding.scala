package app.utils

import app.beans.{Coordinate, Grid}

import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

object PathFinding {

  def buildPath(
    previous: Map[Coordinate, Coordinate],
    step: Coordinate,
    chemin: List[Coordinate] = List()
  ): List[Coordinate] = {
    if (previous.contains(step)) {
      buildPath(previous, previous(step), step :: chemin)
    }
    else {
      step :: chemin
    }
  }

  def explore(
    queue: mutable.PriorityQueue[(Coordinate, Double)],
    distances: mutable.Map[Coordinate, Double], 
    previous: mutable.Map[Coordinate, Coordinate],
    directions: List[Coordinate], 
    end: Coordinate,
    grid: Grid
  ): List[Coordinate] = {
    if (queue.isEmpty) {
      List()
    }
    else {
      val (current, currentDistance) = queue.dequeue()

      if (current == end) {
        val chemin = buildPath(previous.toMap, end)
        chemin
      }
      else {
        directions.foreach { direction =>
          val neighbor = Coordinate(current.x + direction.x, current.y + direction.y)

          if (grid.isValidCoordinate(neighbor)) {
            val newDistance = currentDistance + 1
            if (newDistance < distances(neighbor)) {
              distances(neighbor) = newDistance
              previous(neighbor) = current
              queue.enqueue((neighbor, newDistance))
            }
          }
        }
        explore(queue, distances, previous, directions, end, grid)
      }
    }
  }

  def shortestPath(
    start: Coordinate,
    end: Coordinate,
    grid: Grid
  ): List[Coordinate] = {
    val directions = List(
      Coordinate(1, 0), // droite
      Coordinate(-1, 0), // gauche
      Coordinate(0, 1), // bas
      Coordinate(0, -1) // haut
    )

    val queue = mutable.PriorityQueue[(Coordinate, Double)]()(Ordering.by(-_._2))
    val distances = mutable.Map[Coordinate, Double]().withDefaultValue(Double.PositiveInfinity)
    val previous = mutable.Map[Coordinate, Coordinate]()
    
    distances(start) = 0
    queue.enqueue((start, 0))

    val chemin = explore(queue, distances, previous, directions, end, grid)
    
    if (chemin.isEmpty) List(start) else start :: chemin
  }

  def collision_detected(
    pos1: Coordinate,
    pos2: Coordinate,
    radius: Int
  ): Boolean = {
    val dx = pos1.x - pos2.x
    val dy = pos1.y - pos2.y
    Math.sqrt(dx * dx + dy * dy) < 2 * radius
  }
}
