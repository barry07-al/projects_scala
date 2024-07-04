package app.particule

import scalafx.scene.paint.Color
import app.direction.Direction

final class Particule(val radius: Double, val position: (Double, Double), val color: Color, val direction: Direction) {

    /**
     def updatePosition(boardWidth: Double, boardHeight: Double): Unit = {
        val (x, y) = position

        // Obtenir la direction actuelle de la particule
        val currentDirection = direction

        // Définir les directions des particules voisines
        //val neighborDirections = getNeighborDirections()

        // Déterminer la nouvelle direction en fonction des directions des voisins
        val newDirection = determineNewDirection(currentDirection, neighborDirections)

        // Mettre à jour la direction de la particule
        direction = newDirection

        // Calculer le nouveau déplacement en fonction de la nouvelle direction
        val (dx, dy) = newDirection match {
            case North => (0, -1.0)
            case East => (1.0, 0)
            case South => (0, 1.0)
            case West => (-1.0, 0)
            case NorthEast => (1.0, -1.0)
            case SouthEast => (1.0, 1.0)
            case SouthWest => (-1.0, 1.0)
            case NorthWest => (-1.0, -1.0)
        }

        // Mettre à jour la position en tenant compte des limites du plateau
        val newX = x + dx
        val newY = y + dy
        position = (math.max(0, math.min(newX, boardWidth - radius)), math.max(0, math.min(newY, boardHeight - radius)))
    }
    */
}