pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building project & running all tests...'
                sh '''#!/bin/bash
        mvn clean test
        '''
                // or use 'mvn clean verify' if cucumber reports are generated there
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    junit '**/target/cucumber-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo ' All tests passed!'
        }
        failure {
            echo 'Some tests failed. Check reports in Jenkins.'
        }
    }
}