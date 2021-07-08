node {
    stage 'Clone the project'
    git 'https://github.com/at01071988/All-in-OneStore.git'

    dir('jenkins-pipeline') {
        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                if (isUnix()) {
                    sh "./mvn clean install -DskipTests"
                } else {
                    bat "./mvn.cmd clean install -DskipTests"
                }
            }, 'Static Analysis': {
                stage("Checkstyle") {
                    if (isUnix()) {
                        sh "./mvn checkstyle:checkstyle"
                    } else {
                        bat "./mvn.cmd checkstyle:checkstyle"
                    }
                    step([$class: 'CheckStylePublisher',
                          canRunOnFailed: true,
                          defaultEncoding: '',
                          healthy: '100',
                          pattern: '**/target/checkstyle-result.xml',
                          unHealthy: '90',
                          useStableBuildAsReference: true
                    ])
                }
            }
        }

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Running unit tests") {
                    try {
                        if (isUnix()) {
                            sh "./mvn test"
                        } else {
                            bat "./mvn.cmd test -Punit"
                        }
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])
                        throw err
                    }
                    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])

                }
            }, 'Integration tests': {
                stage("Running integration tests") {
                    try {
                        if (isUnix()) {
                            sh "./mvn test -Pintegration"
                        } else {
                            bat "./mvn.cmd test -Pintegration"
                        }
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*IntegrationTest.xml'])
                        throw err
                    }
                    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*IntegrationTest.xml'])
                }
            }

            stage("Staging") {
                if (isUnix()) {
                    sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid || kill -KILL \$pid"
                } else {
                    bat "FOR /F \"tokens=5 delims= \" %%G IN (\"netstat -a | findstr :8989\") DO TaskKill.exe /PID %%G /fi \"memusage gt 0\""
                }

                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    if (isUnix()) {
                        sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                    } else {
                        bat 'start mvnw.cmd spring-boot:run -Dserver.port=8989'
                    }
                }
            }
        }
    }
}
