package app.utils

import app.beans.{Coordinate, Grid}
import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

object PathFinding {

  def shortestPath(start: Coordinate, end: Coordinate, grid: Grid): List[Coordinate] = {
    val directions = List(
      Coordinate(1, 0),
      Coordinate(-1, 0),
      Coordinate(0, 1),
      Coordinate(0, -1)
    )

    val queue = mutable.PriorityQueue[(Coordinate, Double)]()(Ordering.by(-_._2))
    val distances = mutable.Map[Coordinate, Double]().withDefaultValue(Double.PositiveInfinity)
    val previous = mutable.Map[Coordinate, Coordinate]()
    
    distances(start) = 0
    queue.enqueue((start, 0))

    while (queue.nonEmpty) {
      val (current, currentDistance) = queue.dequeue()
      
      if (current == end) {
        var path = List[Coordinate]()
        var step = end
        while (previous.contains(step)) {
          path = step :: path
          step = previous(step)
        }
        return start :: path
      }
      
      for (direction <- directions) {
        val neighbor = Coordinate(current.x + direction.x, current.y + direction.y)
        
        if (grid.isValidCoordinate(neighbor)) {
          val newDistance = currentDistance + 1 // Distance entre deux voisins adjacents est toujours 1
          
          if (newDistance < distances(neighbor)) {
            distances(neighbor) = newDistance
            previous(neighbor) = current
            queue.enqueue((neighbor, newDistance))
          }
        }
      }
    }
    
    List(start) // Retourne la position de départ si aucun chemin n'est trouvé
  }

  def collision_detected(pos1: Coordinate, pos2: Coordinate, radius: Int): Boolean = {
    val dx = pos1.x - pos2.x
    val dy = pos1.y - pos2.y
    Math.sqrt(dx * dx + dy * dy) < 2 * radius
  }
}
