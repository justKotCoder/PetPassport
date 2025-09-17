plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)

    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.petpassportnew"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.petpassportnew"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // если включишь Crashlytics:
            // firebaseCrashlytics { mappingFileUploadEnabled = true }
        }
        debug {
            // firebaseCrashlytics { mappingFileUploadEnabled = false }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }

    buildFeatures { compose = true }
}

dependencies {
    // ----- Firebase: импортируем BOM во ВСЕ нужные конфигурации -----
    implementation(platform(libs.firebase.bom))
    testImplementation(platform(libs.firebase.bom))
    androidTestImplementation(platform(libs.firebase.bom))

    // Затем — KTX артефакты БЕЗ версий
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.firestore)
    // implementation(libs.firebase.crashlytics) // только если нужен Crashlytics SDK

    // ----- Модули -----
    implementation(project(":core"))
    implementation(project(":core:mvi"))
    implementation(project(":data"))

    implementation(project(":feature:auth"))
    implementation(project(":feature:services"))
    implementation(project(":feature:petpassport"))
    implementation(project(":feature:chat"))
    implementation(project(":feature:profile"))
    implementation(project(":feature:appointments"))
    implementation(project(":feature:settings"))

    // ----- Compose / AndroidX -----
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    // Прочее
    implementation("com.airbnb.android:lottie-compose:6.4.0")

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Coroutines (если нужны)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.play.services)
}
