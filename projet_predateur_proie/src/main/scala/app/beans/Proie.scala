package app.beans

import app.beans.Coordinate

import scalafx.scene.paint.Color


final case class Proie(val position: Coordinate, val rayon: Double, val color: Color, val status: Boolean = false) {

    def move(direction: Int, boardWidth: Int, boardHeight: Int, stepSize: Int): Proie = {
        val (x, y) = (position.x, position.y)
        val (dx, dy, newStatus) = direction match {
            case 1 => (x, y - stepSize, true)
            case 2 => (x, y + stepSize, true)
            case 3 => (x - stepSize, y, true)
            case 4 => (x + stepSize, y, true)
            case _ => (x, y, false)
        }
        val newX = if (dx < 0) (boardWidth - stepSize).toDouble else if (dx >= boardWidth) 0.0 else dx
        val newY = if (dy < 0) (boardHeight - stepSize).toDouble else if (dy >= boardHeight) 0.0 else dy
        copy(position = Coordinate(newX, newY), status = newStatus)
    }

}
