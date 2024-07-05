package app.direction

import scala.util.Random

import app.direction.Direction.*


object DirectionUtils {
  def randomDirection(): Direction = {
    val directions = Direction.values.toArray
    directions(Random.nextInt(directions.length)).asInstanceOf[Direction]
  }
}