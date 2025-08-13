pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'   // Match the exact Maven name in Jenkins
        jdk 'JDK 21'          // Match the exact JDK name in Jenkins
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
                echo 'Starting Spring Boot Application...'
                // Run the WAR file on Windows without wildcard issue
                bat '''
                for %%f in (target\\*.war) do (
                    echo Running %%f
                    java -jar "%%f"
                    exit /b !errorlevel!
                )
                '''
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
