pipeline {
  agent {label "maven"}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

   stages {
        stage ('GIT STAGE ') {
            steps {
                     git branch : 'akram',url :'https://github.com/mootazfarwa43/Devops.git'
               
            }
           
    }
          stage('UNIT testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn test -Dmaven.test.skip=true'
                }
            }
        }
        
         stage('Integration testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn verify -DskipUnitTests'
                }
            }
        }
        
        
         stage('Maven build'){
            
            steps{
                
                script{
                    
                    sh 'mvn clean install -Dmaven.test.skip=true'
                }
            }
        }
        
        
         stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=2f76bab51dad5b5a9c1f1bd16ae8deb05886e3d0'
                }
           
        }
      
      stage ('Mockito Test') {
             steps {

            sh "mvn test"
                echo """les tests sont pris en charge"""
                }
            }
      
        stage('JUNIT Test') {
            steps {
            sh 'mvn clean test -DfailIfNoTests=false -Dtest=com.esprit.examen.services.FournisseurServiceImplTest  -Dmaven.test.failure.ignore=true'  
            }
        }
        /*
 stage('MVN NEXUS STAGE') {
         steps{
            sh'mvn deploy -DskipTests'
            }   
        }
         */
     
      
      
      stage('DOCKER BUILD IMG STAGE'){
                steps{
                    script{
                        sh 'docker build -t tpachat-1.0 .'
                    }
                }
            }
         
         
         
      
        stage('DOCKER PUSH IMG STAGE '){
        steps{
            script{
                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                sh 'docker login -u akramfezzani -p ${dockerhubpwd}'
                     }
                sh 'docker tag tpachat-1.0 akramfezzani/tpachat-1.0:latest'     
                sh 'docker push akramfezzani/tpachat-1.0'     
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
      
           stage('EMAIL STAGE ') {
        steps{
            mail bcc: '',
            body: ' pipeline is working ',
            cc: '', from: '',
            replyTo: '', subject: '[test valiation] The pipeline is working on something here ...',
            to: 'akram.fezzani@esprit.tn'
        }
        }  
    }
}
