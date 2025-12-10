plugins {
    id("java")
}

group = "org.lab"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(26)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// 2. Включаем preview-фичи для компиляции
tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

// 3. Включаем preview-фичи для запуска тестов
tasks.withType<Test>().configureEach {
    jvmArgs("--enable-preview")
}

// 4. Включаем preview-фичи для запуска приложения через run
tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}