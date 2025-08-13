pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Exact Maven name in Jenkins
        jdk 'JDK 21'          // Exact JDK name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/SrikartikMateti/FullStack-1.git', branch: 'main'
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
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Run (Optional)') {
            steps {
                echo 'Starting Spring Boot Application on port 9090...'
                bat '''
                for %%f in (target\\*.war) do (
                    echo Running %%f on port 9090
                    java -jar "%%f" --server.port=9090
                    exit /b !errorlevel!
                )
                '''
                echo 'Waiting for application to start...'
                sleep(time: 5, unit: 'SECONDS')
            }
        }
    }

    post {
        failure {
            echo '❌ Build or tests failed.'
        }
        success {
            echo '✅ Build and tests succeeded.'
            echo '🌐 Access the app at http://localhost:9090'
        }
    }
}
