# java_collections
Learning Java Collections (LinkedIn Learning)

## To get gradle to use Java 17 (instead of 1.8 / Java 8)
#### gradle/wrapper/gradle-wrapper.properties:
org.gradle.java.home=/Library/Java/JavaVirtualMachines/jdk17.0.5-msft.jdk/
#### build.gradle
compileJava.options.fork = true
compileJava.options.forkOptions.executable = '/Library/Java/JavaVirtualMachines/jdk17.0.5-msft.jdk/Contents/Home/bin/javac'
