pipeline {
    agent {label "maven"}
   
    stages {
        stage ('GIT STAGE ') {
            steps {
                     git branch : 'MedAmine',url :'https://github.com/mootazfarwa43/Devops.git'
               
            }
           
    }
         stage('PROJECT COMPILATION STAGE') {
                steps {
                    sh 'mvn clean install -Dmaven.test.skip=true'
                   
                }
               
            }
        
         stage('PACKAGING STAGE'){
                steps{
                    sh 'mvn package  -Dmaven.test.skip=true'
                }
            }
      
         stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=squ_79069b12f407f0d075c45f7c0563a6be6e49658d'
                }
           
        }
        
         stage('MOCKITO TEST STAGE') {
            steps {
           sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplMock' 
            }
        }
        
         stage('JUNIT TEST STAGE') {
            steps {
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'  
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.SecteurActiviteServiceImplTest -Dmaven.test.failure.ignore=true'
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
                        sh 'docker build -t tpachatproject-1.0-s7 .'
                    }
                }
            }
        
          stage('DOCKER PUSH IMG STAGE '){
                steps{
                    script{
                        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u medamine1212 -p ${dockerhubpwd}'
                             }
                        sh 'docker tag tpachatproject-1.0-s7 medamine1212/tpachatproject-1.0-s7:latest'     
                        sh 'docker push medamine1212/tpachatproject-1.0-s7'     
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
        
        stage('DOCKER COMPOSE STAGE') {
            steps{
                script{
                        sh 'docker-compose up -d'
                    }
            }
        }
      
    }
}
