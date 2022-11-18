pipeline {
  agent {label "maven"}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                echo "Getting Project from Git"; 
                git branch: "akram", 
                url: "https://github.com/mootazfarwa43/Devops.git";
                sh "mvn -version"
                
                

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                 //   junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
          stage('UNIT testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn test'
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
                    
                    sh 'mvn clean install'
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
stage('nexus package '){
            steps {
 sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen \
  -DartifactId=tpAchatProject \
  -Dversion=1.0 \
  -Dpackaging=jar\
  -Dfile=target/tpachat-1.0.jar  \
  -DgeneratePom=true \
  -DrepositoryId=achat.repo\
  -Durl=http://192.168.1.25:8081/repository/maven-releases/ '
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
       
        
    }
}
