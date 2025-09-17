plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.petpassport.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(project(":core"))

    // Если здесь работа с Firebase — импортируй BOM и конкретные SDK:
    // implementation(platform(libs.firebase.bom))
    // implementation(libs.firebase.firestore)
    // implementation(libs.firebase.messaging)
    // testImplementation(platform(libs.firebase.bom))
    // androidTestImplementation(platform(libs.firebase.bom))

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // НИКАКОГО compose/ui здесь не нужно, если это data-слой
    testImplementation(libs.junit)
}
