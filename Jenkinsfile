pipeline {
    agent {label "maven"}
   
    stages {
        stage ('GIT STAGE ') {
            steps {
                     git branch : 'MedAmine',url :'https://github.com/mootazfarwa43/Devops.git'
               
            }
           
    }
         stage('Project compilation') {
                steps {
                    sh 'mvn clean install -Dmaven.test.skip=true'
                   
                }
               
            }
        stage('Packaging'){
                steps{
                    sh 'mvn package  -Dmaven.test.skip=true'
                }
            }
         stage('MOCKITO') {
            steps {
           sh 'mvn clean test -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplMock' 
            }
        }
      
    }
}
