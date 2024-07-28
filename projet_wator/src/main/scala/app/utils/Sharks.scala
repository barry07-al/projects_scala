package app.utils

import  app.beans.Position
import  app.utils.Direction.*

final case class Sharks(val position: Position, val direction: Direction, val sBreed: Int, val energy: Int)