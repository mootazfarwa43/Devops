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
        /*
         stage('Packaging'){
                steps{
                    sh 'mvn package  -Dmaven.test.skip=true'
                }
            }
      
         stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=squ_79069b12f407f0d075c45f7c0563a6be6e49658d'
                }
           
        }
        
         stage('MOCKITO') {
            steps {
           sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplMock' 
            }
        }
        
         stage('JUNIT') {
            steps {
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'  
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'
            }
        }
        */
        stage('MVN NEXUS STAGE') {
         steps{
            sh'mvn deploy -DskipTests'
            }   
        }
        
        stage('DOCKER BUILD IMG STAGE'){
                steps{
                    script{
                        sh 'docker build -t tpAchatProject-1.0 .'
                    }
                }
            }
        
          stage('DOCKER PUSH IMG STAGE '){
                steps{
                    script{
                        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u medamine1212 -p ${dockerhubpwd}'
                             }
                        sh 'docker tag tpAchatProject-1.0 medamine1212/tpAchatProject-1.0:latest'     
                        sh 'docker push medamine1212/tpAchatProject-1.0'     
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
