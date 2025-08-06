pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Ensure this name matches the one in Global Tool Configuration
        jdk 'JDK 21'          // Same here
    }

    environment {
        PATH = "${tool 'Maven 3.8.6'}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/SrikartikMateti/FullStack-1.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
