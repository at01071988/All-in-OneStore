pipeline {
    agent any
    tools {
        maven 'local_maven'
        jdk 'local_jdk'
    }
    enviornment{
        NEW_VERSION='1.3.0'
    }
    stages{
        stage('Build') { 
                steps {
                   echo 'mvn install'
                }
            }
         stage('Test') { 
                steps {
                   echo 'mvn clean test'
                }
            }
         stage('Deploy') { 
                steps { 
                   echo 'This is a minimal pipeline.' 
                }
            }
    }
}
