package app.utils

import scala.util.Random

import app.utils.Direction.*


object DirectionUtils {

  def randomDirection(): Direction = {
    val directions = Direction.values.toArray
    directions(Random.nextInt(directions.length)).asInstanceOf[Direction]
  }

}