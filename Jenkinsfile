pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'     // Make sure this name matches Jenkins -> Global Tool Configuration
        jdk 'JDK 21'            // Ensure JDK 21 is configured on Jenkins
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://your.repo.url/demo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package WAR') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed.'
        }
        success {
            echo 'Build succeeded.'
        }
    }
}
