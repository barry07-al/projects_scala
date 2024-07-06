package app

import app.particule.{Particule, Particules}
import scalafx.application.JFXApp3
import scalafx.geometry.Rectangle2D
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.animation.Timeline
import scalafx.util.Duration
import scalafx.animation.KeyFrame
import scalafx.scene.shape.Circle
import scalafx.stage.Screen

object Main extends JFXApp3 {

  val particleRadius: Int    = 3
  val numberOfParticles: Int = 1500
  
  override def start(): Unit = {
    val screenBounds: Rectangle2D = Screen.primary.visualBounds
    val boardWidth = screenBounds.width.toInt
    val boardHeight = screenBounds.height.toInt
    var particles = new Particules(numberOfParticles, particleRadius, boardWidth, boardHeight)
    
    stage = new JFXApp3.PrimaryStage {
      title.value = "Simulation de Particules"
      width = boardWidth
      height = boardHeight
      scene = new Scene {
        fill = White
        val particleNodes = particles.getParticles().map(drawParticule)
        content = particleNodes

        val timeline = new Timeline {
          cycleCount = Timeline.Indefinite
          keyFrames = Seq(
            KeyFrame(Duration(20), onFinished = _ => {
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

  def drawParticule(p: Particule): Circle = {
    new Circle {
      centerX = p.position._1
      centerY = p.position._2
      radius = p.radius
      fill = p.color
    }
  }
}
