pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Exact name from Jenkins global tool config
        jdk 'JDK 21'          // Exact name from Jenkins global tool config
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        // Optional: Run the Spring Boot app for verification
        stage('Run (Optional)') {
            steps {
                echo 'Starting Spring Boot Application...'
                bat 'java -jar target/*.jar'
            }
        }
    }

    post {
        failure {
            echo '❌ Build or tests failed.'
        }
        success {
            echo '✅ Build and tests succeeded.'
        }
    }
}
