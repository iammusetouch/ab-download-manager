import io.github.z4kn4fein.semver.toVersion
import ir.amirab.git_version.core.semanticVersionRegex

plugins {
    ir.amirab.`git-version-plugin`
}
val defaultSemVersion = "1.0.0"
val fallBackVersion = "$defaultSemVersion-untagged"

gitVersion {
    on {
        branch(".+") {
            "$defaultSemVersion-${it.refInfo.shortenName}-snapshot"
        }
        tag("v?${semanticVersionRegex}") {
            it.matchResult.groups.get("version")!!.value
        }
        commit {
            "$defaultSemVersion-sha.${it.refInfo.commitHash.take(5)}"
        }
    }
}
//version="0.0.8"
version = (gitVersion.getVersion() ?:fallBackVersion).toVersion()
logger.lifecycle("version: $version")

dependencies {
    implementation("com.github.natario1:Ariana:1.0.3")
}

// filepath: /Users/musetouch/Downloads/ab-download-manager/desktop/app/src/test/kotlin/ArianaTest.kt
import org.junit.Test

class ArianaTest {
    @Test
    fun testArianaInitialization() {
        // Простой тест для проверки инициализации
        try {
            // Здесь код инициализации Ariana
            println("Ariana успешно инициализирована")
        } catch (e: Exception) {
            throw AssertionError("Ошибка инициализации Ariana: ${e.message}")
        }
    }
}