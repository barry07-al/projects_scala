package app

import app.particule.Particule
import app.particule.Particles
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.animation.Timeline
import scalafx.util.Duration
import scalafx.Includes._
import scalafx.animation.KeyFrame
import scalafx.scene.shape.Circle
import scalafx.collections.ObservableBuffer

object Main extends JFXApp3 {

  val numParticles = 1500
  val particleRadius = 3

  var particles = new Particles(numParticles, particleRadius)

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "Particules Simulation"
      width = 1200
      height = 1200
      scene = new Scene {
        fill = White
        val particleNodes = particles.getParticles().map(p => drawParticule(p))
        content = particleNodes

        val timeline = new Timeline {
          cycleCount = Timeline.Indefinite
          keyFrames = Seq(
            KeyFrame(Duration(10), onFinished = _ => {
              particles = particles.update()
              particleNodes.zip(particles.getParticles()).foreach {
                case (node, particle) =>
                  node.centerX = particle.position._1
                  node.centerY = particle.position._2
              }
            })
          )
        }
        timeline.play()
      }
    }
  }

  def drawParticule(p: Particule) = {
    new Circle {
      centerX = p.position._1
      centerY = p.position._2
      radius = p.radius
      fill = p.color
    }
  }
}
