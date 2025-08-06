pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Use exact name as in Jenkins
        jdk 'JDK 21'          // Use exact name as in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/SrikartikMateti/FullStack-1.git', branch: 'main'
            }
        }

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
