pipeline {
    agent any
    
    stages {
        stage ('GIT') {
            steps {
                git branch : 'MedAmine',url :'https://github.com/mootazfarwa43/Devops.git'
                
            }
            
    }
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
            
        }
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
            
        }
        }
        }
