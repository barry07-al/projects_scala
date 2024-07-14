package app.beans

case class Grid(val width: Int, val height: Int) {

  def isValidCoordinate(coord: Coordinate): Boolean = {
    coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height
  }
}