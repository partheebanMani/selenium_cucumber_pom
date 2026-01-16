pipeline {
    agent any

    parameters {
         string(name: 'BRANCH', defaultValue: 'jenkinsFileConfig', description: 'Branch to build and test')
         string(name: 'MAVEN_OPTS', defaultValue: '', description: 'Optional Maven commands for test execution')
    }

    tools{
        maven 'Maven-3.9.6'
    }

    stages {
        stage('Test') {
            steps {
                sh "mvn test ${params.MAVEN_OPTS}"
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
                    reportFiles: 'overview-tags.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
}
