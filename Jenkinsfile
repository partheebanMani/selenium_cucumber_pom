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

    post {
            always {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'consolidated.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
}
