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
                sh 'docker login -u medamine1212 -p dockerpassword'
                sh 'docker rmi --force tpachatproject-1.0-s7'
                sh 'docker tag tpachatproject-1.0-s7 medamine1212/tpachatproject-1.0-s7:latest'     
                sh 'docker push medamine1212/tpachatproject-1.0-s7'     
            }

        }

    }

        stage('DOCKER COMPOSE STAGE') {
            steps{
                script{
                        sh 'docker-compose up -d'
                    }
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
        
        stage('EMAIL STAGE ') {
        steps{
            mail bcc: '',
            body: 'Heyy , the pipeline is working just fine with no errors ! all steps succeded. Congrats 😁😁 ',
            cc: '', from: '',
            replyTo: '', subject: 'Pipeline success',
            to: 'medamine.khaili@esprit.tn'
        }
        }  
      
    }
}
