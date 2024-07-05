file://<WORKSPACE>/projet_particules/src/main/scala/app/Main.scala
### java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      = new Timeline(
  new KeyFrame(Duration.millis(10)) {
    var onFinished =
      (_$1: ActionEvent) =>
        {
          particles.update()
          content = particles.getParticles.map(p => drawParticule(p))
        }
  } timeline _root_.scala.Predef.???
) # -1,
parent span = <1054..1339>,
child       = new KeyFrame(Duration.millis(10)) {
  var onFinished =
    (_$1: ActionEvent) =>
      {
        particles.update()
        content = particles.getParticles.map(p => drawParticule(p))
      }
} timeline _root_.scala.Predef.??? # -1,
child span  = [1074..1278..1342]

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/projet_particules/src/main/scala/app/Main.scala
text:
```scala
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
import scalafx.Includes._
import scalafx.animation.KeyFrame
import scalafx.beans.property.IntegerProperty
import javafx.scene.input.KeyCode
import scala.util.Random
import scalafx.scene.shape.Circle


object Main extends JFXApp3 {

  val numParticles = 1500
  val particleRadius = 3

  val particles = new Particles(numParticles, particleRadius)

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title.value = "Particules Simulation"
      width = 1200
      height = 1200
      scene = new Scene {
        fill = White
        content = particles.getParticles().map(p => drawParticule(p))
      }
    }

    // Create and start the animation timeline
    val timeline = new Timeline(
      new KeyFrame(Duration.millis(10)) {
        var onFinished = (_: ActionEvent) => {
          particles.update()
          content = particles.getParticles.map(p => drawParticule(p))
        }
      }
    timeline.cycleCount = Timeline.INDEFINITE
    timeline.play()
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

```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:177)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:207)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:207)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:207)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:207)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:207)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:207)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:202)
	dotty.tools.dotc.ast.Positioned.check$1$$anonfun$3(Positioned.scala:207)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:333)
	dotty.tools.dotc.ast.Positioned.check$1(Positioned.scala:207)
	dotty.tools.dotc.ast.Positioned.checkPos(Positioned.scala:228)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:39)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:477)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:40)
	dotty.tools.dotc.parsing.Parser.$anonfun$2(ParserPhase.scala:52)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:684)
	scala.collection.immutable.List$.from(List.scala:681)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:898)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:53)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:315)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:337)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:350)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:360)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:360)
	dotty.tools.dotc.Run.compileSources(Run.scala:261)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
	dotty.tools.pc.MetalsDriver.run(MetalsDriver.scala:47)
	dotty.tools.pc.PcCollector.<init>(PcCollector.scala:42)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:106)
```
#### Short summary: 

java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      = new Timeline(
  new KeyFrame(Duration.millis(10)) {
    var onFinished =
      (_$1: ActionEvent) =>
        {
          particles.update()
          content = particles.getParticles.map(p => drawParticule(p))
        }
  } timeline _root_.scala.Predef.???
) # -1,
parent span = <1054..1339>,
child       = new KeyFrame(Duration.millis(10)) {
  var onFinished =
    (_$1: ActionEvent) =>
      {
        particles.update()
        content = particles.getParticles.map(p => drawParticule(p))
      }
} timeline _root_.scala.Predef.??? # -1,
child span  = [1074..1278..1342]