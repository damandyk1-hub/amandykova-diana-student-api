pipeline {
    agent any

    environment {
        STUDENT = 'Amandykova Diana'
        IMAGE = 'amandykova-diana-student-api:v1.0-amandykova-diana'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Pipeline started by ${STUDENT}"
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE} ."
            }
        }

        stage('Verify') {
            steps {
                sh "docker images ${IMAGE}"
                echo "Image ${IMAGE} built successfully. Student: ${STUDENT}"
            }
        }
    }

    post {
        success {
            echo "Pipeline finished OK - ${STUDENT}"
        }
        failure {
            echo "Pipeline FAILED - ${STUDENT}"
        }
    }
}
