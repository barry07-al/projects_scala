package app.particule

import scalafx.scene.paint.Color
import app.direction.Direction
import app.direction.Direction._
import scala.util.Random
import app.direction.DirectionUtils
import scalafx.scene.input.KeyCode.P

final case class Particule(val radius: Double, val position: (Double, Double), val color: Color, val direction: Direction) {

  def update(boardWidth: Int, boardHeight: Int, particles: Array[Particule]): Particule = {
    // Déplacement en fonction de la direction
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

    // Nouvelles coordonnées après déplacement
    val newX = (position._1 + dx + boardWidth) % boardWidth
    val newY = (position._2 + dy + boardHeight) % boardHeight

    // Vérification de collision avec d'autres particules en vérifiant
    // si la distance entre les particules est inférieure à 2 fois le rayon
    val collision = particles.exists(p => p != this && distance(p.position, (newX, newY)) < radius * 2)

    if (collision) {
      // Changement de direction aléatoire
      Particule(radius, (position._1, position._2), color, DirectionUtils.randomDirection())
    } else {
      // Déplacement de la particule à la nouvelle position
      Particule(radius, (newX, newY), color, direction)
    }
  }

  private def distance(p1: (Double, Double), p2: (Double, Double)): Double = {
    // Distance entre deux points
    Math.sqrt(Math.pow(p1._1 - p2._1, 2) + Math.pow(p1._2 - p2._2, 2))
  }
}
