package app.beans

import app.utils.PathFinding
import scalafx.scene.paint.Color

final case class Predateur(val position: Coordinate, val radius: Double, val color: Color) {

  def update(newPosition: Coordinate): Predateur = {
    copy(position = newPosition)
  }

  def move(proiePosition: Coordinate, proieStatus: Boolean, grid: Grid, stepSize: Int): Predateur = {
    if (proieStatus) {
      val path = PathFinding.shortestPath(position, proiePosition, grid)
      val newPosition = if (path.size > stepSize) path(stepSize) else path.last
      update(newPosition)
    } else {
      this
    }
  }
}