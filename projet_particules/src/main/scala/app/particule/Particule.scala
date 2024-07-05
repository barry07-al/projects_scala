package app.particule

import scalafx.scene.paint.Color
import app.direction.Direction
import app.direction.Direction._
import scala.util.Random
import app.direction.DirectionUtils

final class Particule(val radius: Double, val position: (Double, Double), val color: Color, val direction: Direction) {

  def updatePosition(boardWidth: Double, boardHeight: Double, particles: Array[Particule]): Particule = {
    val (x, y) = position
    val (dx, dy) = direction match {
      case North => (0.0, -1.0)
      case East => (1.0, 0.0)
      case South => (0.0, 1.0)
      case West => (-1.0, 0.0)
      case NorthEast => (1.0, -1.0)
      case SouthEast => (1.0, 1.0)
      case SouthWest => (-1.0, 1.0)
      case NorthWest => (-1.0, -1.0)
    }
    val newX = x + dx
    val newY = y + dy

    // Gestion du rebondissement sur les bords
    val (newDirectionX, newDirectionY) = {
      if (newX <= 0 || newX >= boardWidth - radius) (-dx, dy)
      else (dx, dy)

      if (newY <= 0 || newY >= boardHeight - radius) (dx, -dy)
      else (dx, dy)

      (dx, dy)
    }

    // Vérifier la collision avec les autres particules
    val collided = particles.exists(p => p != this && collideWith(p))
    val newPos = (math.max(0, math.min(newX, boardWidth - radius)), math.max(0, math.min(newY, boardHeight - radius)))
    new Particule(radius, newPos, color, if (collided) DirectionUtils.randomDirection() else direction)
  }

  private def collideWith(other: Particule): Boolean = {
    val (dx, dy) = (position._1 - other.position._1, position._2 - other.position._2)
    val distance = math.sqrt(dx * dx + dy * dy)
    distance <= radius + other.radius
  }
}
