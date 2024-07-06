package app.particule

import scalafx.scene.paint.Color
import app.direction.DirectionUtils
import scala.util.Random

case class Particules(particles: Array[Particule], boardWidth: Int, boardHeight: Int) {

  def this(numberOfParticles: Int, particleRadius: Int, boardWidth: Int, boardHeight: Int) = {
    this(Array.fill(numberOfParticles)(
      Particule(
        particleRadius,
        (Random.nextDouble() * boardWidth, Random.nextDouble() * boardHeight),
        Color(Random.nextDouble(), Random.nextDouble(), Random.nextDouble(), 1.0),
        DirectionUtils.randomDirection()
      )
    ), boardWidth, boardHeight)
  }

  def update(): Particules = {
    val updatedParticles = particles.map(_.update(boardWidth, boardHeight, particles))
    copy(particles = updatedParticles)
  }

  def getParticles(): Array[Particule] = particles
}
