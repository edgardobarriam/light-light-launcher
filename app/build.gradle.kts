plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
}
android {
  namespace = "io.github.edgardobarriam.lightlightlauncher"
  compileSdk = 35
  defaultConfig {
    applicationId = "io.github.edgardobarriam.lightlightlauncher"
    minSdk = 24
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"
  }
  buildTypes {
    all {
      isDebuggable = false
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt")
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}
