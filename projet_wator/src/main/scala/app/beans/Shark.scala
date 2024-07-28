package app.beans

import app.utils.Direction.*

final case class Shark(val position: Position, val direction: Direction, val sBreed: Int, val energy: Int)