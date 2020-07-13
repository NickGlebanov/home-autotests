import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "ru.raiffeisen1"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	implementation("io.cucumber:cucumber-java:6.2.2")
	implementation("io.cucumber:cucumber-java8:6.2.2")
	implementation("io.cucumber:cucumber-testng:6.2.2")
	implementation("io.cucumber:cucumber-spring:6.2.2")
	implementation("com.codeborne:selenide:5.11.1")
	implementation("org.apache.commons:commons-lang3:3.10")
	implementation("io.qameta.allure:allure-cucumber5-jvm:2.13.3")
	implementation("io.qameta.allure:allure-testng:2.13.3")
	implementation("net.lightbody.bmp:browsermob-core:2.1.5")
	implementation("com.google.guava:guava:29.0-jre")
	implementation("ru.yandex.qatools.ashot:ashot:1.5.4")



}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
