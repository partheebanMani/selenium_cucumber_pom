pipeline {
    agent any

    tools{
        maven 'Maven-3.9.6'
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
