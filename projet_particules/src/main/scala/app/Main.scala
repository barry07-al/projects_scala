package app

import app.particule.Particule
import app.particule.Particles

import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.beans.property.ObjectProperty
import scalafx.animation.Timeline
import scalafx.animation.Timeline.*
import scalafx.util.Duration
import scalafx.animation.KeyFrame
import scalafx.beans.property.IntegerProperty
import javafx.scene.input.KeyCode
import scala.util.Random
import scalafx.scene.shape.Circle


object Main extends JFXApp3 {

  val numParticles = 1000
  val particleRadius = 5

  val particles = new Particles(numParticles, particleRadius)

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "Particules Simulation"
      width = 1200
      height = 1200
      scene = new Scene {
        fill = White
        content = particles.getParticles.map(p => drawParticule(p))
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
