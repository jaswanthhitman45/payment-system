pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = "your-docker-id/payment-app:${env.BUILD_NUMBER}"
        DOCKER_CREDS = 'docker-hub-credentials-id' // ID of credentials stored in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build & Tag') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDS}", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "echo \$PASS | docker login -u \$USER --password-stdin"
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Updates the deployment with the new image
                sh "kubectl apply -f k8s/deployment.yaml"
                sh "kubectl apply -f k8s/service.yaml"
                sh "kubectl set image deployment/payment-deployment payment-container=${DOCKER_IMAGE}"
            }
        }
    }
}
