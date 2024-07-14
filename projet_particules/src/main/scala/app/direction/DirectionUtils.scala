package app.direction

import app.direction.Direction.*

import scala.util.Random


object DirectionUtils {

  def randomDirection(): Direction = {
    val directions = Direction.values.toArray
    directions(Random.nextInt(directions.length)).asInstanceOf[Direction]
  }

}