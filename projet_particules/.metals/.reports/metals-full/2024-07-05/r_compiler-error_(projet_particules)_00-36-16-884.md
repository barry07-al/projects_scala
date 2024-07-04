file://<WORKSPACE>/src/main/scala/app/particule/Particles.scala
### java.lang.AssertionError: assertion failed: position error, parent span does not contain child span
parent      = new Particule(particleRadius, (rand.nextInt(450), rand.nextInt(600)),
  Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 1.0),
  _root_.scala.Predef.???) # -1,
parent span = <262..419>,
child       = _root_.scala.Predef.??? # -1,
child span  = [419..452..452]

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/src/main/scala/app/particule/Particles.scala
text:
```scala
package app.particule

import scalafx.scene.paint.Color
import scala.util.Random



class Particles(val numberOfParticles: Int, val particleRadius: Int) {

  val rand = new Random()

  private val particles: Array[Particule] = Array.fill(numberOfParticles)(
    new Particule(
      particleRadius,
      (rand.nextInt(450), rand.nextInt(600)),
      Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 1.0), // Add the missing argument for

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
parent      = new Particule(particleRadius, (rand.nextInt(450), rand.nextInt(600)),
  Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 1.0),
  _root_.scala.Predef.???) # -1,
parent span = <262..419>,
child       = _root_.scala.Predef.??? # -1,
child span  = [419..452..452]