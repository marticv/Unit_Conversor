plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.marti_cv.unitconversor"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.marti_cv.unitconversor"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.android.dagger.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val hilt_version="2.47"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    //Dagger hilt
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")
    implementation("androidx.test:runner:1.5.2")


    //LiveData para corrutinas
    implementation("androidx.compose.runtime:runtime-livedata:1.6.0")

    // For Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:$hilt_version")
    // ...with Java.
    testAnnotationProcessor("com.google.dagger:hilt-android-compiler:$hilt_version")
    kaptTest("com.google.dagger:hilt-android-compiler:$hilt_version")



    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Robolecrtic
    testImplementation("org.robolectric:robolectric:4.11.1")
    //Hamcrest
    testImplementation("org.hamcrest:hamcrest:2.2")
    // Kotlin extensions for androidx.test.core
    testImplementation("androidx.test:core-ktx:1.5.0")
    // Kotlin extensions for androidx.test.ext.junit
    testImplementation("androidx.test.ext:junit-ktx:1.1.5")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
