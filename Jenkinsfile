node {
    stage 'Clone the project'
    git 'https://github.com/at01071988/All-in-OneStore.git'

    dir('jenkins-pipeline') {
        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                "mvn clean install -DskipTests"
            }
        }

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Running unit tests") {
                   "mvn clean test"
                }
            }
            
        }
    }
}
