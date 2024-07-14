package app.beans

case class Grid(width: Int, height: Int) {

  def isValidCoordinate(coord: Coordinate): Boolean = {
    coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height
  }

  def neighbors(coord: Coordinate): List[Coordinate] = {
    val size = 5
    List(
      Coordinate(coord.x - size, coord.y),
      Coordinate(coord.x + size, coord.y),
      Coordinate(coord.x, coord.y - size),
      Coordinate(coord.x, coord.y + size)
    ).filter(isValidCoordinate)
  }
}