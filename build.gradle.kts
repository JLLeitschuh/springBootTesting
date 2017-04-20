import org.gradle.api.tasks.wrapper.Wrapper

group = "org.jlleitschuh.boot-test"
version = "1.0-SNAPSHOT"


task<Wrapper>("wrapper") {
    distributionUrl = "https://repo.gradle.org/gradle/dist-snapshots/gradle-script-kotlin-3.5-20170404014535+0000-all.zip"
    distributionType = Wrapper.DistributionType.ALL
}