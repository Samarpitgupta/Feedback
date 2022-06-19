// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.6")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.6")

addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.0.3")