package app.beans

import app.utils.Direction.*

final case class Tuna(val position: Position, val direction: Direction, val tBreed: Int, val isDead: Boolean) {

    def move(boardWidth: Int, boardHeight: Int): Tuna = {
        val neighbours = Array(
            Position(position.x, position.y - 1),
            Position(position.x, position.y + 1),
            Position(position.x - 1, position.y),
            Position(position.x + 1, position.y)
        )

        val freeNeighbours = neighbours.filter(n => n.x >= 0 && n.x < boardWidth && n.y >= 0 && n.y < boardHeight)

        if (freeNeighbours.isEmpty) {
            copy()
        } else {
            val newPosition = freeNeighbours(scala.util.Random.nextInt(freeNeighbours.length))
            copy(position = newPosition)
        }

    }
}