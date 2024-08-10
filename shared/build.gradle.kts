import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    js {
        useCommonJs()
        nodejs {
            testTask {
                useMocha {
                    timeout = "10m"
                }
            }
        }
        binaries.executable()
        dependencies {
            implementation(npm("crypto-js", "4.1.1"))
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val jvmAndAndroidMain by creating {
            dependsOn(commonMain.get())
        }

        androidMain.get().dependsOn(jvmAndAndroidMain)
        jvmMain.get().dependsOn(jvmAndAndroidMain)
    }
}

android {
    namespace = "ru.transaero21.flymeapi.shared"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}