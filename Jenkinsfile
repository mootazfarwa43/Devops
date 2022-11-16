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
           sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplMock' 
            }
        }
        
         stage('JUNIT') {
            steps {
            sh 'mvn clean test -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'  
            sh 'mvn clean test -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'
            }
        }
        
    stage('MVN TEST STAGE') {
        steps{
            sh'mvn test'
        }
        post {
            always {
            junit testResults: '*/target/surefire-reports/.xml', allowEmptyResults: true
        }
        }
          
        }
        
        stage('MVN NEXUS STAGE') {
         steps{
            sh'mvn deploy -DskipTests'
            }   
        }
        
        stage('DOCKER BUILD IMG STAGE'){
                steps{
                    script{
                        sh 'docker build -t achat-1.0-s7 .'
                    }
                }
            }
        
          stage('DOCKER PUSH IMG STAGE '){
                steps{
                    script{
                        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u medamine1212 -p ${dockerhubpwd}'
                             }
                        sh 'docker tag  achat-1.0-s7 medamine1212/achat-1.0-s7:latest'     
                        sh 'docker push medamine1212/achat-1.0-s7'     
                    }
                   
                }
               
            }
        
            stage('EMAIL STAGE ') {
        steps{
            mail bcc: '',
            body: 'Heyy , Med Amine Khaili s pipeline is working ',
            cc: '', from: '',
            replyTo: '', subject: '[test valiation] The pipeline is working on something here ...',
            to: 'medamine.khaili@esprit.tn'
        }
        }   
      
    }
}
