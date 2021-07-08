pipeline {
    agent any
    tools {
        maven 'local_maven'
        jdk 'local_jdk'
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
