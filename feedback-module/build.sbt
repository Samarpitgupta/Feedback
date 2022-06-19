name := "feedback-module"

version := "1.0-SNAPSHOT"


resolvers += "Secured Central Repository" at "https://repo1.maven.org/maven2"

externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)

libraryDependencies ++= Seq(javaJdbc, javaEbean, 
"mysql" % "mysql-connector-java" % "8.0.18",
"org.springframework" % "spring-jdbc" % "4.1.6.RELEASE",
"org.springframework" % "spring-dao" % "2.0.6", 
"org.springframework" % "spring-core" % "5.2.4.RELEASE",
"com.google.code.gson" % "gson" % "2.8.5",
"com.google.inject" % "guice" % "4.0",
"org.springframework" % "spring-web" % "5.2.4.RELEASE",
"org.mockito" % "mockito-core" % "2.10.0" % "test",
"org.sonarsource.sonarqube" % "sonar-plugin-api" % "7.1",
"org.apache.commons" % "commons-compress" % "1.4.1"
) 

play.Project.playJavaSettings
