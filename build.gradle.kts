plugins {
    kotlin("jvm") version "1.6.10"  
    id("au.com.dius.pact") version "4.1.7"
    application
}

sourceSets {
    main {
        java.srcDirs("src/main/spike/contractTest")
    }

    test {
        java.srcDirs("src/main/spike/contractTest")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation(kotlin("test"))
    testImplementation("net.wuerl.kotlin:assertj-core-kotlin:0.2.1")
    testImplementation("au.com.dius.pact.consumer:java8:4.1.7")
    testImplementation("au.com.dius.pact.consumer:junit5:4.1.7")
    testImplementation("org.apache.httpcomponents:fluent-hc:4.5.6")
}

application {
    mainClassName = "spike.contractTest.MainKt"
}

tasks {
    test {
        useJUnitPlatform()
    }
}
