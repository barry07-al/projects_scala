package app.utils

import app.beans.Tuna
import app.beans.Position

import scala.util.Random
import scalafx.scene.paint.Color


final case class Tunas(val tunas: Array[Tuna], val boardWidth: Int, val boardHeight: Int) {
  
    def this(numberOfTunas: Int, boardWidth: Int, boardHeight: Int) = {
        this(
            Array.fill(numberOfTunas)(
                Tuna(
                    new Position(Random.nextDouble() * boardWidth, Random.nextDouble() * boardHeight),
                    null,
                    0,
                    false
                )
            ),
            boardWidth,
            boardHeight
        )
    }

    /**
    def update(): Tunas = {
        val updatedTunas = tunas.map(_.update(boardWidth, boardHeight, tunas))
        copy(tunas = updatedTunas)
    }
    */
}