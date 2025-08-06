pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Use exact name as in Jenkins
        jdk 'JDK 21'          // Use exact name as in Jenkins
    }

    stages {
    

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        failure {
            echo 'Build or tests failed.'
        }
        success {
            echo 'Build and tests succeeded.'
        }
    }
}
